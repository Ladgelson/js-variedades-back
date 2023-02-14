package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.dto.request.FinishSaleRequest;
import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.enums.SaleStatus;
import jsvariedades.sales.exceptions.NotFound;
import jsvariedades.sales.mapper.SaleItemMapper;
import jsvariedades.sales.mapper.SaleMapper;
import jsvariedades.sales.model.SaleModel;
import jsvariedades.sales.model.base.BaseModel;
import jsvariedades.sales.repository.PaymentTypeRepository;
import jsvariedades.sales.repository.SaleItemRepository;
import jsvariedades.sales.repository.SaleRepository;
import jsvariedades.sales.repository.StoreRepository;
import jsvariedades.sales.service.ProductService;
import jsvariedades.sales.service.SaleHistoryService;
import jsvariedades.sales.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static jsvariedades.sales.enums.SaleAction.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);

    private final SaleItemRepository saleItemRepository;

    private final SaleRepository saleRepository;

    private final ProductService productService;

    private final SaleHistoryService saleHistoryService;

    private final PaymentTypeRepository paymentTypeRepository;

    private final StoreRepository storeRepository;

    public SaleServiceImpl(SaleItemRepository saleItemRepository, SaleRepository saleRepository, ProductService productService, SaleHistoryService saleHistoryService, PaymentTypeRepository paymentTypeRepository, StoreRepository storeRepository) {
        this.saleItemRepository = saleItemRepository;
        this.saleRepository = saleRepository;
        this.productService = productService;
        this.saleHistoryService = saleHistoryService;
        this.paymentTypeRepository = paymentTypeRepository;
        this.storeRepository = storeRepository;
    }

    @Override
    @LogExecution
    public SaleModel findByIdSale(Long id) {
        return saleRepository.findById(id).orElseThrow( () -> {
            logger.error("m=findByIdSale id={} stage=error message=Sale was not found", id);
            throw new NotFound("Sale was not found");
        });
    }

    @Override
    @LogExecution
    @Transactional
    public void finishSale(Long id, FinishSaleRequest finishSaleRequest) {
        var sale = findByIdSale(id);
        sale.getItems().forEach( item -> {
            var product = item.getProduct();
            var lastFrequency = product.getFrequency();
            product.setFrequency(lastFrequency + item.getQuantity());
        });

        var paymentTypes = paymentTypeRepository.findAll()
                .stream()
                .filter(paymentType -> finishSaleRequest.getPaymentTypes().contains(paymentType.getType().name()))
                .collect(Collectors.toList());
        sale.setPaymentTypes(paymentTypes);
        sale.setObs(finishSaleRequest.getObs());
        sale.setStatus(SaleStatus.FINISHED);
        saleHistoryService.save(sale, FINISH);
    }

    @Override
    @LogExecution
    public Page<SaleModel> findSalesPaginated(Pageable pageable) {
        return saleRepository.findAll(pageable);
    }

    @Override
    @LogExecution
    public SaleDTO initSale() {
        var store = storeRepository.findById(1L).get();
        var newSale = new SaleModel()
                .setStore(store)
                .setStatus(SaleStatus.STARTED)
                .setTotal(new BigDecimal(0))
                .setObs("");
        saleRepository.save(newSale);
        saleHistoryService.save(newSale, START);
        return SaleMapper.saleModelToSaleDto(newSale, List.of());
    }

    @Override
    @LogExecution
    public SaleItemResponse addItem(Long id, SaleItemRequest item) {
        var sale = findByIdSale(id);
        var product = productService.findById(item.getProductId());
        var newItem = SaleItemMapper.saleItemRequestToSaleItemModel(item)
                .setSale(sale)
                .setProduct(product);
        saleItemRepository.save(newItem);
        updateTotal(sale);
        saleHistoryService.save(sale, ADD_ITEM);
        return SaleItemMapper.saleItemModelToSaleItemResponse(newItem);
    }

    private void updateTotal(SaleModel sale) {
        var dValue =  sale.getItems()
                .stream()
                .mapToDouble(item -> item.getValue().multiply(BigDecimal.valueOf(item.getQuantity())).doubleValue())
                .sum();
        var total = BigDecimal.valueOf(dValue);
        sale.setTotal(total);
    }

    @Override
    @LogExecution
    public void removeItem(Long id, Long idItem) {
        var sale = findByIdSale(id);
        saleItemRepository.deleteById(idItem);
        updateTotal(sale);
        saleHistoryService.save(sale, REMOVE_ITEM);
    }

    @Override
    @LogExecution
    public void resetSale(Long id) {
        var sale = findByIdSale(id);
        sale.setStatus(SaleStatus.RESTARTED);
        sale.setTotal(BigDecimal.ZERO);
        sale.setPaymentTypes(new ArrayList<>());
        saleItemRepository.deleteAllById(sale.getItems().stream().map(BaseModel::getId).collect(Collectors.toList()));
        saleRepository.save(sale);
        saleHistoryService.save(sale, RESTART);
    }

    @Override
    @LogExecution
    public void changeQuantity(Long id, SaleItemRequest item, Long idItem) {
        var sale = findByIdSale(id);
        var itemToBeChanged = sale.getItems()
                .stream()
                .filter(currentItem -> currentItem.getId().equals(idItem))
                .findFirst().orElseThrow(() -> {
                    logger.error("m=changeQuantity idItem={} stage=error message=Item was not found", idItem);
                    return new NotFound("Sale was not found");
                });
        itemToBeChanged.setQuantity(item.getQuantity());
        updateTotal(sale);
        saleItemRepository.save(itemToBeChanged);
        saleHistoryService.save(sale, ALTER_QUANTITY_ITEM);
    }
}

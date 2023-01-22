package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.enums.SaleStatus;
import jsvariedades.sales.exceptions.NotFound;
import jsvariedades.sales.mapper.SaleItemMapper;
import jsvariedades.sales.mapper.SaleMapper;
import jsvariedades.sales.model.SaleModel;
import jsvariedades.sales.repository.SaleItemRepository;
import jsvariedades.sales.repository.SaleRepository;
import jsvariedades.sales.service.ProductService;
import jsvariedades.sales.service.SaleHistoryService;
import jsvariedades.sales.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static jsvariedades.sales.enums.SaleAction.*;

@Service
public class SaleServiceImpl implements SaleService {

    private final Logger logger = LoggerFactory.getLogger(SaleServiceImpl.class);

    private final SaleItemRepository saleItemRepository;

    private final SaleRepository saleRepository;

    private final ProductService productService;

    private final SaleHistoryService saleHistoryService;

    public SaleServiceImpl(SaleItemRepository saleItemRepository, SaleRepository saleRepository, ProductService productService, SaleHistoryService saleHistoryService) {
        this.saleItemRepository = saleItemRepository;
        this.saleRepository = saleRepository;
        this.productService = productService;
        this.saleHistoryService = saleHistoryService;
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
    public void finishSale(Long id) {
        var sale = findByIdSale(id);
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
        var newSale = new SaleModel()
                .setStatus(SaleStatus.STARTED)
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
        saleHistoryService.save(sale, ADD_ITEM);
        return SaleItemMapper.saleItemModelToSaleItemResponse(newItem);
    }

    @Override
    @LogExecution
    public void removeItem(Long id, Long idItem) {
        var sale = findByIdSale(id);
        saleHistoryService.save(sale, REMOVE_ITEM);
        saleRepository.deleteById(idItem);
    }

    @Override
    @LogExecution
    public void resetSale(Long id) {
        var sale = findByIdSale(id);
        sale.setStatus(SaleStatus.RESTARTED);
        saleHistoryService.save(sale, RESTART);
    }
}

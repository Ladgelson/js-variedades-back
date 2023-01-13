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
import jsvariedades.sales.service.SaleService;
import org.hibernate.ObjectNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    private final SaleItemRepository saleItemRepository;

    private final SaleRepository saleRepository;

    private final ProductService productService;

    public SaleServiceImpl(SaleItemRepository saleItemRepository, SaleRepository saleRepository, ProductService productService) {
        this.saleItemRepository = saleItemRepository;
        this.saleRepository = saleRepository;
        this.productService = productService;
    }

    @Override
    @LogExecution
    public SaleModel findByIdSale(Long id) {
        return saleRepository.findById(id).orElseThrow( () -> {
            throw new NotFound("Object not found");
        });
    }

    @Override
    @LogExecution
    public void finishSale(Long id) {
        var sale = findByIdSale(id);
        sale.setStatus(SaleStatus.FINISHED);
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
        return SaleMapper.saleModelToSaleDto(newSale, List.of());
    }

    @Override
    @LogExecution
    public SaleItemResponse addItem(Long id, SaleItemRequest item) {
        var sale = findByIdSale(id);
        var product = productService.findByIdProduct(item.getProductId());
        var newItem = SaleItemMapper.saleRequestToSaleModel(item)
                .setSale(sale)
                .setProduct(product);
        saleItemRepository.save(newItem);
        return SaleItemMapper.saleItemModelToSaleItemResponse(newItem);
    }

    @Override
    public void removeItem(Long idSale, Long idItem) {
        saleRepository.deleteById(idItem);
    }

    @Override
    @LogExecution
    public void resetSale(Long id) {
        var sale = findByIdSale(id);
        sale.setStatus(SaleStatus.RESTARTED);
    }
}

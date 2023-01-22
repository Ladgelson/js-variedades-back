package jsvariedades.sales.controller.v1.impl;

import jsvariedades.sales.controller.v1.SaleController;
import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.mapper.SaleMapper;
import jsvariedades.sales.service.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleControllerImpl implements SaleController {

    private final SaleService saleService;

    public SaleControllerImpl(SaleService saleService) {
        this.saleService = saleService;
    }

    @Override
    public ResponseEntity<Page<SaleDTO>> findSalesPaginated(Pageable pageable) {
        var pages = saleService.findSalesPaginated(pageable).map(SaleMapper::saleModelToSaleDto);
        return ResponseEntity.ok(pages);
    }

    @Override
    public ResponseEntity<SaleDTO> findById(Long id) {
        var sale = saleService.findByIdSale(id);
        return ResponseEntity.ok(SaleMapper.saleModelToSaleDto(sale));
    }

    @Override
    public ResponseEntity<SaleDTO> initSale() {
        var sale = saleService.initSale();
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SaleItemResponse> addItem(Long id, SaleItemRequest item) {
        var sale = saleService.addItem(id,item);
        return ResponseEntity.ok(sale);
    }

    @Override
    public ResponseEntity<SaleItemResponse> changeQuantity(Long id, SaleItemRequest item, String idItem) {
        return null;
    }

    @Override
    public ResponseEntity<Void> removeItem(Long idSale, Long idItem) {
        saleService.removeItem(idSale,idItem);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> resetSale(Long id) {
        saleService.resetSale(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> finishSale(Long id) {
        saleService.finishSale(id);
        return ResponseEntity.ok().build();
    }
}

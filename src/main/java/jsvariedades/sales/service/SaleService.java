package jsvariedades.sales.service;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.model.SaleModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface SaleService {

    SaleModel findByIdSale(@PathVariable Long id);

    void finishSale(@PathVariable Long id);

    Page<SaleModel> findSalesPaginated(Pageable pageable);

    SaleDTO initSale();

    SaleItemResponse addItem(@PathVariable Long id, @RequestBody SaleItemRequest item);

    void removeItem(@PathVariable Long idSale, @PathVariable Long idItem);

    void resetSale(@PathVariable Long id);


}

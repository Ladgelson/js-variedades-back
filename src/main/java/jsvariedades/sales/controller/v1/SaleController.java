package jsvariedades.sales.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Sales", description = "Resource to manage sales of the company")
@RequestMapping("/api/v1/sales")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface SaleController {
    @Operation(description = "Find Sales paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sales found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping
    ResponseEntity<Page<SaleDTO>> findSalesPaginated(Pageable pageable);

    @Operation(description = "Find Sale by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<SaleDTO> findById(@PathVariable Long id);

    @Operation(description = "Initialize a Sale on the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sale created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<SaleDTO> initSale();

    @Operation(description = "Add a new item in a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/add-item")
    ResponseEntity<SaleItemResponse> addItem(@PathVariable Long id, @RequestBody SaleItemRequest item);

    @Operation(description = "Change quantity of item")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item quantity changed", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/change-quantity/{idItem}")
    ResponseEntity<SaleItemResponse> changeQuantity(@PathVariable Long id, @RequestBody SaleItemRequest item, @PathVariable String idItem);

    @Operation(description = "Delete a item of a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item deleted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping("/{idSale}/items/{idItem}")
    ResponseEntity<Void> removeItem(@PathVariable Long idSale, @PathVariable Long idItem);

    @Operation(description = "Reset a Sale from zero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale restarted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/reset")
    ResponseEntity<Void> resetSale(@PathVariable Long id);

    @Operation(description = "Finish a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale finished", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/finish")
    ResponseEntity<Void> finishSale(@PathVariable Long id);
}

package jsvariedades.sales.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Sales", description = "Resource to manage sales of the company")
@RequestMapping("/api/v1/sales")
public interface SaleController {
    @Operation(description = "Find Sales paginated")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sales found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping
    ResponseEntity<Page<?>> findSalesPaginated(Pageable pageable);

    @Operation(description = "Find Sale by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale found", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable int id);

    @Operation(description = "Initialize a Sale on the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Sale created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<?> initSale();

    @Operation(description = "Add a new item in a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item added", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/add-item")
    ResponseEntity<?> addItem(@PathVariable int id, @RequestBody Object item);

    @Operation(description = "Delete a item of a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Item deleted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @DeleteMapping("/{idSale}/items/{idItem}")
    ResponseEntity<?> removeItem(@PathVariable int idSale, @PathVariable int idItem);

    @Operation(description = "Reset a Sale from zero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale restarted", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/reset")
    ResponseEntity<?> resetSale(@PathVariable int id);

    @Operation(description = "Finalize a Sale")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sale finished", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/finish")
    ResponseEntity<?> finishSale(@PathVariable int id);
}

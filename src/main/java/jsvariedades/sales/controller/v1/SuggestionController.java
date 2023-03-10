package jsvariedades.sales.controller.v1;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Suggestion", description = "Resource to manage suggestions of things to buy")
@RequestMapping("/api/v1/suggestions")
public interface SuggestionController {
    @Operation(description = "Create a new suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Suggestion successfully created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping
    ResponseEntity<?> createSuggestion();

    @Operation(description = "Create a item of a suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Item successfully created", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/add-item")
    ResponseEntity<?> addItem(@RequestBody Object item, @PathVariable String id);

    @Operation(description = "Finish a suggestion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Suggestion successfully finished", content = @Content),
            @ApiResponse(responseCode = "400", description = "Missing or invalid path variable", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)})
    @PostMapping("/{id}/finish")
    ResponseEntity<?> finishSuggestion(@PathVariable String id);
}

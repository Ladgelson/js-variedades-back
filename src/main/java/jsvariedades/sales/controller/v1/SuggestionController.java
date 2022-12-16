package jsvariedades.sales.controller.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/suggestions")
public interface SuggestionController {
    @PostMapping
    ResponseEntity<?> createSuggestion();

    @PostMapping("/{id}/add-item")
    ResponseEntity<?> addItem(@RequestBody Object item, @PathVariable String id);

    @PostMapping("/{id}/finish")
    ResponseEntity<?> finishSuggestion(@PathVariable String id);
}

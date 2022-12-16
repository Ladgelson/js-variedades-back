package jsvariedades.sales.controller.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/sales")
public interface SaleController {
    @GetMapping
    ResponseEntity<Page<?>> findSalesPaginated(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable int id);

    @PostMapping
    ResponseEntity<?> initSale();

    @PostMapping("/{id}/add-item")
    ResponseEntity<?> addItem(@PathVariable int id, @RequestBody Object item);

    @DeleteMapping("/{idSale}/items/{idItem}")
    ResponseEntity<?> removeItem(@PathVariable int idSale, @PathVariable int idItem);

    @PostMapping("/{id}/reset")
    ResponseEntity<?> resetSale(@PathVariable int id);

    @PostMapping("/{id}/finish")
    ResponseEntity<?> finishSale(@PathVariable int id);
}

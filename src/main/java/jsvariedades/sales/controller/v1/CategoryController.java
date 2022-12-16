package jsvariedades.sales.controller.v1;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/categories")
public interface CategoryController {
    @GetMapping
    ResponseEntity<Page<?>> findCategoriesPaginated(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable int id);

    @PostMapping
    ResponseEntity<?> saveCategory(@RequestBody Object category);

    @DeleteMapping("/{id}")
    ResponseEntity<?> updatedCategory(@PathVariable int id, @RequestBody Object updateCategory);

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCategory(@PathVariable int id);
}

package jsvariedades.sales.controller.v1;

import jsvariedades.sales.dto.common.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/categories")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface CategoryController {
    @GetMapping
    ResponseEntity<Page<CategoryDTO>> findCategoriesPaginated(Pageable pageable);

    @GetMapping("/{id}")
    ResponseEntity<CategoryDTO> findById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<Void> saveCategory(@RequestBody @Validated CategoryDTO category);

    @PutMapping("/{id}")
    ResponseEntity<CategoryDTO> updatedCategory(@PathVariable Long id, @RequestBody @Validated CategoryDTO updateCategory);

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteCategory(@PathVariable Long id);
}

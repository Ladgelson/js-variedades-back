package jsvariedades.sales.controller.v1.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.controller.v1.CategoryController;
import jsvariedades.sales.dto.common.CategoryDTO;
import jsvariedades.sales.mapper.CategoryMapper;
import jsvariedades.sales.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryControllerImpl implements CategoryController {
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @LogExecution
    public ResponseEntity<Page<CategoryDTO>> findCategoriesPaginated(Pageable pageable) {
        return ResponseEntity.ok(categoryService.findCategoriesPaginated(pageable));
    }

    @Override
    @LogExecution
    public ResponseEntity<CategoryDTO> findById(Long id) {
        var category = categoryService.findById(id);
        return ResponseEntity.ok(CategoryMapper.categoryModelToCategoryDto(category));
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> saveCategory(CategoryDTO category) {
        var categoryEntity = CategoryMapper.categoryDtoToCategoryModel(category);
        categoryService.save(categoryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    @LogExecution
    public ResponseEntity<CategoryDTO> updatedCategory(Long id, CategoryDTO updateCategory) {
        categoryService.updateCategory(id, CategoryMapper.categoryDtoToCategoryModel(updateCategory));
        return ResponseEntity.ok().build();
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> deleteCategory(Long id) {
        categoryService.delete(id);
        return ResponseEntity.ok().build();
    }
}

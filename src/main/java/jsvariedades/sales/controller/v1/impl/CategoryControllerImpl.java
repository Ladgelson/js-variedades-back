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

    private final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);
    private final CategoryService categoryService;

    public CategoryControllerImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    @LogExecution
    public ResponseEntity<Page<CategoryDTO>> findCategoriesPaginated(Pageable pageable) {
        logger.info("m=findCategoriesPaginated stage=init");
        return ResponseEntity.ok(categoryService.findCategoriesPaginated(pageable));

    }

    @Override
    @LogExecution
    public ResponseEntity<CategoryDTO> findById(Long id) {
        var category = categoryService.findById(id);
        logger.info("m=findById stage=init");
        return ResponseEntity.ok(CategoryMapper.categoryModelToCategoryDto(category));
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> saveCategory(CategoryDTO category) {
        logger.info("m=saveCategory stage=init categoryDto={}", category);
        var categoryEntity = CategoryMapper.categoryDtoToCategoryModel(category);
        categoryService.save(categoryEntity);
        logger.info("m=saveCategory stage=finish");
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Override
    public ResponseEntity<CategoryDTO> updatedCategory(Long id, CategoryDTO updateCategory) {
        logger.info("m=saveCategory stage=init id={} categoryDto={}",id, updateCategory);
        categoryService.updateCategory(id, CategoryMapper.categoryDtoToCategoryModel(updateCategory));
        logger.info("m=saveCategory stage=finish");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> deleteCategory(Long id) {
        logger.info("m=deleteCategory stage=init id={}", id);
        categoryService.delete(id);
        logger.info("m=deleteCategory stage=finish");
        return ResponseEntity.ok().build();
    }
}

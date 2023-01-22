package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.controller.v1.impl.CategoryControllerImpl;
import jsvariedades.sales.dto.common.CategoryDTO;
import jsvariedades.sales.exceptions.NotFound;
import jsvariedades.sales.mapper.CategoryMapper;
import jsvariedades.sales.model.CategoryModel;
import jsvariedades.sales.repository.CategoryRepository;
import jsvariedades.sales.service.CategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    @LogExecution
    public Page<CategoryDTO> findCategoriesPaginated(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(CategoryMapper::categoryModelToCategoryDto);
    }

    @Override
    @LogExecution
    public CategoryModel findById(Long id) {
        return categoryRepository.findById(id).orElseThrow( () -> {
            logger.error("m=findById stage=error id={} message=Category was not found", id);
            return new NotFound("Error: Categoria não encontrada.");
        });
    }

    @Override
    @LogExecution
    public CategoryModel save(CategoryModel category) {
        return categoryRepository.save(category);
    }

    @Override
    @LogExecution
    public void updateCategory(Long id, CategoryModel categoryModel) {
        var category = findById(id);
        updateData(category, categoryModel);
        categoryRepository.save(category);
    }

    @Override
    @LogExecution
    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }

    private void updateData(CategoryModel c1, CategoryModel c2){
        c1.setName(c2.getName());
    }
}

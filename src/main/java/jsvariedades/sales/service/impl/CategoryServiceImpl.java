package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.controller.v1.impl.CategoryControllerImpl;
import jsvariedades.sales.dto.common.CategoryDTO;
import jsvariedades.sales.mapper.CategoryMapper;
import jsvariedades.sales.model.CategoryModel;
import jsvariedades.sales.repository.CategoryRepository;
import jsvariedades.sales.service.CategoryService;
import org.hibernate.ObjectNotFoundException;
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
            logger.info("m=findById stage=error id={}", id);
            return new ObjectNotFoundException("Error: Categoria não encontrada.", id);
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
        var category = categoryRepository.findById(id)
                .orElseThrow( () -> {
                    logger.error("m=updateCategory stage=error id={} categoryModel={}", id, categoryModel);
                    return new ObjectNotFoundException("error", id);
                });
        updateData(category, categoryModel);
        categoryRepository.save(category);
    }

    @Override
    @LogExecution
    public void delete(Long id) {
        try{
            categoryRepository.deleteById(id);
        } catch (Exception ignore){}
    }

    private void updateData(CategoryModel c1, CategoryModel c2){
        c1.setName(c2.getName());
    }
}

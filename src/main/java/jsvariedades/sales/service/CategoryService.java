package jsvariedades.sales.service;

import jsvariedades.sales.dto.common.CategoryDTO;
import jsvariedades.sales.model.CategoryModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CategoryService {

    Page<CategoryDTO> findCategoriesPaginated(Pageable pageable);

    CategoryModel findById(Long id);

    CategoryModel save(CategoryModel category);

    void updateCategory(Long id, CategoryModel categoryDTO);

    void delete(Long id);

}

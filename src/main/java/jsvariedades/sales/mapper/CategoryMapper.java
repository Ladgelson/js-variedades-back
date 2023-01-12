package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.common.CategoryDTO;
import jsvariedades.sales.model.CategoryModel;

public final class CategoryMapper {

    public static CategoryModel categoryDtoToCategoryModel(CategoryDTO categoryDTO){
        return new CategoryModel().setName(categoryDTO.getName());
    }

    public static CategoryDTO categoryModelToCategoryDto(CategoryModel category){
        return new CategoryDTO().setName(category.getName());
    }

}

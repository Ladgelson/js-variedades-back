package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.model.ProductModel;

public final class ProductMapper {

    public static ProductResponse productModelToProductResponse(ProductModel productModel){
        return new ProductResponse()
                .setName(productModel.getName())
                .setDescription(productModel.getDescription())
                .setFrequency(productModel.getFrequency())
                .setId(productModel.getId())
                .setImgLink("null")
                .setPurchasePrice(productModel.getPurchasePrice())
                .setSaleValue(productModel.getSaleValue());
    }

    public static ProductRequest productModelToProductRequest(ProductModel productModel){
        return new ProductRequest()
                .setName(productModel.getName())
                .setDescription(productModel.getDescription())
                .setImgLink("null")
                .setPurchasePrice(productModel.getPurchasePrice())
                .setSaleValue(productModel.getSaleValue());
    }

    public static ProductDTO productDtoToProductModel(ProductModel productModel){
        return new ProductDTO()
                .setName(productModel.getName())
                .setPurchasePrice(productModel.getPurchasePrice())
                .setSaleValue(productModel.getSaleValue())
                .setDescription(productModel.getDescription())
                .setCategory(CategoryMapper.categoryModelToCategoryDto(productModel.getCategory()))
                .setFrequency(productModel.getFrequency())
                .setId(productModel.getId());
    }

    public static ProductModel productModelToProductRequest(ProductRequest productModel){
        return new ProductModel()
                .setName(productModel.getName())
                .setDescription(productModel.getDescription())
                .setPurchasePrice(productModel.getPurchasePrice())
                .setSaleValue(productModel.getSaleValue());
    }

}

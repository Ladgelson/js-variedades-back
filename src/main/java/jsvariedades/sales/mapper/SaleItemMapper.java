package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.model.SaleItemModel;

public class SaleItemMapper {

    public static SaleItemModel saleItemRequestToSaleItemModel(SaleItemRequest saleItemRequest){
        return new SaleItemModel()
                .setValue(saleItemRequest.getValue())
                .setQuantity(saleItemRequest.getQuantity());
    }

    public static SaleItemResponse saleItemModelToSaleItemResponse(SaleItemModel saleItemModel){
        return new SaleItemResponse()
                .setId(saleItemModel.getId())
                .setValue(saleItemModel.getValue())
                .setProduct(ProductMapper.productModelToProductResponse(saleItemModel.getProduct()))
                .setQuantity(saleItemModel.getQuantity());
    }

}

package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.request.SaleItemRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.model.SaleItemModel;
import jsvariedades.sales.model.SaleModel;

public class SaleItemMapper {

    public static SaleItemModel saleRequestToSaleModel(SaleItemRequest saleItemRequest){
        return new SaleItemModel()
                .setValue(saleItemRequest.getValue());
    }

    public static SaleItemResponse saleItemModelToSaleItemResponse(SaleItemModel saleItemModel){
        return new SaleItemResponse()
                .setValue(saleItemModel.getValue())
                .setProduct(ProductMapper.productModelToProductResponse(saleItemModel.getProduct()));
    }

}

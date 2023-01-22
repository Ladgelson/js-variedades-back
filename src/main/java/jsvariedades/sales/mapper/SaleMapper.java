package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.common.SaleDTO;
import jsvariedades.sales.model.SaleItemModel;
import jsvariedades.sales.model.SaleModel;

import java.util.List;
import java.util.stream.Collectors;

public final class SaleMapper {

    public static SaleDTO saleModelToSaleDto(SaleModel sale, List<SaleItemModel> items){
        return new SaleDTO()
                .setTotal(sale.getTotal())
                .setItems(items.stream().map(SaleItemMapper::saleItemModelToSaleItemResponse).collect(Collectors.toList()))
                .setStatus(sale.getStatus())
                .setPaymentTypes(sale.getPaymentTypes().stream().map(PaymentTypeMapper::paymentModelToPaymentTypeDto).collect(Collectors.toSet()))
                .setStoreId(sale.getStore().getId())
                .setObs(sale.getObs());
    }

    public static SaleDTO saleModelToSaleDto(SaleModel sale){
        return new SaleDTO()
                .setTotal(sale.getTotal())
//                .setItems(items.stream().map(SaleItemMapper::saleItemModelToSaleItemResponse).collect(Collectors.toList()))
                .setStatus(sale.getStatus())
                .setPaymentTypes(sale.getPaymentTypes().stream().map(PaymentTypeMapper::paymentModelToPaymentTypeDto).collect(Collectors.toSet()))
                .setStoreId(sale.getStore().getId())
                .setObs(sale.getObs());
    }

}

package jsvariedades.sales.mapper;

import jsvariedades.sales.dto.common.PaymentTypeDTO;
import jsvariedades.sales.model.PaymentTypeModel;

public class PaymentTypeMapper {

    public static PaymentTypeDTO paymentModelToPaymentTypeDto(PaymentTypeModel payment) {
        return new PaymentTypeDTO(payment);
    }
}

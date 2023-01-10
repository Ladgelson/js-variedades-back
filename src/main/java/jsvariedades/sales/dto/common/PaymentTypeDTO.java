package jsvariedades.sales.dto.common;

import jsvariedades.sales.enums.PaymentType;

public class PaymentTypeDTO {

    private PaymentType type;

    public PaymentType getType() {
        return type;
    }

    public PaymentTypeDTO setType(PaymentType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentTypeDTO{" +
                "type=" + type +
                '}';
    }
}

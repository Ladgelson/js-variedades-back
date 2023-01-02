package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.PaymentType;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_payment_type")
public class PaymentTypeModel extends BaseModel {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private PaymentType type;

    public PaymentTypeModel(){}

    public PaymentTypeModel(PaymentType type) {
        this.type = type;
    }

    public PaymentType getType() {
        return type;
    }

    public PaymentTypeModel setType(PaymentType type) {
        this.type = type;
        return this;
    }

    @Override
    public String toString() {
        return "PaymentTypeModel{" +
                "type=" + type +
                '}';
    }
}

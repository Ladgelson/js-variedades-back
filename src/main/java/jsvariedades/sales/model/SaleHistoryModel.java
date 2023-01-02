package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.SaleAction;
import jsvariedades.sales.enums.SaleStatus;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_sale_history")
public class SaleHistoryModel extends BaseModel {

    @ManyToOne
    private SaleModel sale;

    @Enumerated(value = EnumType.STRING)
    private SaleStatus status;

    @Enumerated(value = EnumType.STRING)
    private SaleAction action;

    public SaleHistoryModel() {
    }

    public SaleHistoryModel(SaleModel sale, SaleStatus status, SaleAction action) {
        this.sale = sale;
        this.status = status;
        this.action = action;
    }

    public SaleModel getSale() {
        return sale;
    }

    public SaleHistoryModel setSale(SaleModel sale) {
        this.sale = sale;
        return this;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public SaleHistoryModel setStatus(SaleStatus status) {
        this.status = status;
        return this;
    }

    public SaleAction getAction() {
        return action;
    }

    public SaleHistoryModel setAction(SaleAction action) {
        this.action = action;
        return this;
    }

    @Override
    public String toString() {
        return "SaleHistoryModel{" +
                "sale=" + sale +
                ", status=" + status +
                ", action=" + action +
                '}';
    }
}

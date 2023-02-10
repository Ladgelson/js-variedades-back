package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.enums.SaleStatus;
import jsvariedades.sales.model.base.BaseModel;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_sale")
public class SaleModel extends BaseModel {

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SaleStatus status;

    @Column(nullable = false)
    private String obs;

    @Column
    private BigDecimal total;

    @ManyToOne
    private StoreModel store;

    @OneToMany // TODO FIX HERE
    private List<PaymentTypeModel> paymentTypes = new ArrayList<>();

    public List<SaleItemModel> getItems() {
        return items;
    }

    public SaleModel setItems(List<SaleItemModel> items) {
        this.items = items;
        return this;
    }

    @OneToMany(mappedBy = "sale")
    private List<SaleItemModel> items = new ArrayList<>();

    public SaleModel(){}

    public SaleModel(SaleStatus status, String obs, BigDecimal total, StoreModel store, List<PaymentTypeModel> paymentTypes) {
        this.status = status;
        this.obs = obs;
        this.total = total;
        this.store = store;
        this.paymentTypes = paymentTypes;
    }

    public SaleStatus getStatus() {
        return status;
    }

    public SaleModel setStatus(SaleStatus status) {
        this.status = status;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public SaleModel setObs(String obs) {
        this.obs = obs;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public SaleModel setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public StoreModel getStore() {
        return store;
    }

    public SaleModel setStore(StoreModel store) {
        this.store = store;
        return this;
    }

    public List<PaymentTypeModel> getPaymentTypes() {
        return paymentTypes;
    }

    public SaleModel setPaymentTypes(List<PaymentTypeModel> paymentTypes) {
        this.paymentTypes = paymentTypes;
        return this;
    }

    @Override
    public String toString() {
        return "SaleModel{" +
                "status=" + status +
                ", obs='" + obs + '\'' +
                ", total=" + total +
                ", store=" + store +
                ", paymentTypes=" + paymentTypes +
                '}';
    }
}

package jsvariedades.sales.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jsvariedades.sales.model.base.BaseModel;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_sale_item")
public class SaleItemModel extends BaseModel {

    @Column(nullable = false)
    private BigDecimal value;

    @ManyToOne
    private ProductModel product;

    @ManyToOne
    private SaleModel sale;

    public SaleItemModel() {
    }

    public SaleItemModel(BigDecimal value, ProductModel product, SaleModel sale) {
        this.value = value;
        this.product = product;
        this.sale = sale;
    }

    public BigDecimal getValue() {
        return value;
    }

    public SaleItemModel setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public ProductModel getProduct() {
        return product;
    }

    public SaleItemModel setProduct(ProductModel product) {
        this.product = product;
        return this;
    }

    public SaleModel getSale() {
        return sale;
    }

    public SaleItemModel setSale(SaleModel sale) {
        this.sale = sale;
        return this;
    }

    @Override
    public String toString() {
        return "SaleItemModel{" +
                "value=" + value +
                ", product=" + product +
                ", sale=" + sale +
                '}';
    }
}

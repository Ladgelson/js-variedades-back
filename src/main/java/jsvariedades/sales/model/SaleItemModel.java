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

    private int quantity;

    public SaleItemModel() {
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

    public int getQuantity() {
        return quantity;
    }

    public SaleItemModel setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "SaleItemModel{" +
                "value=" + value +
                ", product=" + product +
                ", sale=" + sale +
                ", quantity=" + quantity +
                '}';
    }
}

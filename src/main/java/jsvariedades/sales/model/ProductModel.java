package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_product")
public class ProductModel extends BaseModel {

    @Column(nullable = false)
    private String name;

    @Column(nullable = true, scale = 2)
    private BigDecimal purchasePrice;

    @Column(nullable = false)
    private BigDecimal saleValue;

    @Column(nullable = false)
    private int frequency;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private StoreModel store;

    @ManyToOne
    private CategoryModel category;

    public ProductModel() {
    }

    public ProductModel(String name, BigDecimal purchasePrice, BigDecimal saleValue, int frequency, String description, StoreModel store, CategoryModel category) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.saleValue = saleValue;
        this.frequency = frequency;
        this.description = description;
        this.store = store;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public ProductModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductModel setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductModel setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public ProductModel setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public StoreModel getStore() {
        return store;
    }

    public ProductModel setStore(StoreModel store) {
        this.store = store;
        return this;
    }

    public CategoryModel getCategory() {
        return category;
    }

    public ProductModel setCategory(CategoryModel category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", saleValue=" + saleValue +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                ", store=" + store +
                ", category=" + category +
                '}';
    }
}

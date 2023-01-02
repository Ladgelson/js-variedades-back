package jsvariedades.sales.model;

import jakarta.persistence.*;
import jsvariedades.sales.model.base.BaseModel;

@Entity
@Table(name = "tb_suggestion_item")
public class SuggestionItemModel extends BaseModel {

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private ProductModel productModel;

    @Column(nullable = true)
    private Integer quantity;

    @ManyToOne
    private SuggestionModel suggestion;

    public SuggestionItemModel() {
    }

    public SuggestionItemModel(String description, ProductModel productModel, Integer quantity, SuggestionModel suggestion) {
        this.description = description;
        this.productModel = productModel;
        this.quantity = quantity;
        this.suggestion = suggestion;
    }

    public String getDescription() {
        return description;
    }

    public SuggestionItemModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public ProductModel getProductModel() {
        return productModel;
    }

    public SuggestionItemModel setProductModel(ProductModel productModel) {
        this.productModel = productModel;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public SuggestionItemModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public SuggestionModel getSuggestion() {
        return suggestion;
    }

    public SuggestionItemModel setSuggestion(SuggestionModel suggestion) {
        this.suggestion = suggestion;
        return this;
    }

    @Override
    public String toString() {
        return "SuggestionItemModel{" +
                "description='" + description + '\'' +
                ", productModel=" + productModel +
                ", quantity=" + quantity +
                ", suggestion=" + suggestion +
                '}';
    }
}

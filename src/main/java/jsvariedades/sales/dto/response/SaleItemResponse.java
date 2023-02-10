package jsvariedades.sales.dto.response;

import java.math.BigDecimal;

public class SaleItemResponse {

    private Long id;

    private BigDecimal value;

    private ProductResponse product;

    private int quantity;

    public BigDecimal getValue() {
        return value;
    }

    public SaleItemResponse setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public ProductResponse getProduct() {
        return product;
    }

    public SaleItemResponse setProduct(ProductResponse product) {
        this.product = product;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SaleItemResponse setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SaleItemResponse setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "SaleItemResponse{" +
                "id=" + id +
                ", value=" + value +
                ", product=" + product +
                ", quantity=" + quantity +
                '}';
    }
}

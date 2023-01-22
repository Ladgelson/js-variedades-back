package jsvariedades.sales.dto.request;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class SaleItemRequest {

    @NotNull
    private BigDecimal value;

    @NotNull
    private Long productId;

    @NotNull
    private int quantity;

    public BigDecimal getValue() {
        return value;
    }

    public SaleItemRequest setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public SaleItemRequest setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    public int getQuantity() {
        return quantity;
    }

    public SaleItemRequest setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    @Override
    public String toString() {
        return "SaleItemRequest{" +
                "value=" + value +
                ", productId=" + productId +
                ", quantity=" + quantity +
                '}';
    }
}

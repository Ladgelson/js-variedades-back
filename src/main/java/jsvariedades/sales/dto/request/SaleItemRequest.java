package jsvariedades.sales.dto.request;

import java.math.BigDecimal;

public class SaleItemRequest {
    private BigDecimal value;
    private Long productId;

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

    @Override
    public String toString() {
        return "SaleItemRequest{" +
                "value=" + value +
                ", productId=" + productId +
                '}';
    }
}

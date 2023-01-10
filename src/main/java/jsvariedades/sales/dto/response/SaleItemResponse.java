package jsvariedades.sales.dto.response;

import java.math.BigDecimal;

public class SaleItemResponse {
    private BigDecimal value;
    private ProductResponse product;

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

    @Override
    public String toString() {
        return "SaleItemResponse{" +
                "value=" + value +
                ", product=" + product +
                '}';
    }
}

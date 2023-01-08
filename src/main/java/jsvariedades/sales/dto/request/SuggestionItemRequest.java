package jsvariedades.sales.dto.request;

import jakarta.validation.constraints.NotBlank;

public class SuggestionItemRequest {
    @NotBlank(message = "Suggestion description is mandatory")
    private String description;

    private Long quantity;

    private Long productId;

    public String getDescription() {
        return description;
    }

    public SuggestionItemRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public SuggestionItemRequest setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public Long getProductId() {
        return productId;
    }

    public SuggestionItemRequest setProductId(Long productId) {
        this.productId = productId;
        return this;
    }

    @Override
    public String toString() {
        return "SuggestionRequest{" +
                "description='" + description + '\'' +
                ", quantity=" + quantity +
                ", productId=" + productId +
                '}';
    }
}

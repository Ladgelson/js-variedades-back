package jsvariedades.sales.dto.common;

import java.time.LocalDateTime;

public class SuggestionItemDTO {

    private Long id;

    private String description;

    private Long quantity;

    private ProductDTO product;

    private LocalDateTime createdDate;

    public Long getId() {
        return id;
    }

    public SuggestionItemDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SuggestionItemDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getQuantity() {
        return quantity;
    }

    public SuggestionItemDTO setQuantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public SuggestionItemDTO setProduct(ProductDTO product) {
        this.product = product;
        return this;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public SuggestionItemDTO setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    @Override
    public String toString() {
        return "SuggestionItemDTO{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", quantity=" + quantity +
                ", product=" + product +
                ", createdDate=" + createdDate +
                '}';
    }
}

package jsvariedades.sales.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public class ProductRequest {

    @NotBlank(message = "Product name is mandatory")
    private String name;

    private BigDecimal purchasePrice;

    @NotNull(message = "Sale value of this product is mandatory")
    private BigDecimal saleValue;

    private String imgLink;

    @NotBlank(message = "Product description is mandaroty")
    private String description;

    @NotNull(message = "StoreId is required when saving products")
    private Long storeId;

    private Long catgoryId;

    public String getName() {
        return name;
    }

    public ProductRequest setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductRequest setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductRequest setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public String getImgLink() {
        return imgLink;
    }

    public ProductRequest setImgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductRequest setDescription(String description) {
        this.description = description;
        return this;
    }

    public Long getStoreId() {
        return storeId;
    }

    public ProductRequest setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public Long getCatgoryId() {
        return catgoryId;
    }

    public ProductRequest setCatgoryId(Long catgoryId) {
        this.catgoryId = catgoryId;
        return this;
    }

    @Override
    public String toString() {
        return "ProductRequest{" +
                "name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", saleValue=" + saleValue +
                ", imgLink='" + imgLink + '\'' +
                ", description='" + description + '\'' +
                ", storeId=" + storeId +
                ", catgoryId=" + catgoryId +
                '}';
    }
}

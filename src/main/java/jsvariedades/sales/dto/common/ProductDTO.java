package jsvariedades.sales.dto.common;

import java.math.BigDecimal;

public class ProductDTO {

    private Long id;

    private String name;

    private BigDecimal purchasePrice;

    private BigDecimal saleValue;

    private int frequency;


    private String imgLink;

    private String description;

    private CategoryDTO category;

    public String getImgLink() {
        return imgLink;
    }

    public ProductDTO setImgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ProductDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductDTO setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductDTO setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductDTO setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public ProductDTO setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public ProductDTO setCategory(CategoryDTO category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", saleValue=" + saleValue +
                ", frequency=" + frequency +
                ", imgLink='" + imgLink + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}

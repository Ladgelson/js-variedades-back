package jsvariedades.sales.dto.response;

import java.math.BigDecimal;

public class ProductResponse {

    private Long id;

    private String name;

    private BigDecimal purchasePrice;

    private BigDecimal saleValue;

    private String imgLink;

    private int frequency;

    private String description;

    public Long getId() {
        return id;
    }

    public ProductResponse setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ProductResponse setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPurchasePrice() {
        return purchasePrice;
    }

    public ProductResponse setPurchasePrice(BigDecimal purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public ProductResponse setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
        return this;
    }

    public String getImgLink() {
        return imgLink;
    }

    public ProductResponse setImgLink(String imgLink) {
        this.imgLink = imgLink;
        return this;
    }

    public int getFrequency() {
        return frequency;
    }

    public ProductResponse setFrequency(int frequency) {
        this.frequency = frequency;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductResponse setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", saleValue=" + saleValue +
                ", imgLink='" + imgLink + '\'' +
                ", frequency=" + frequency +
                ", description='" + description + '\'' +
                '}';
    }
}

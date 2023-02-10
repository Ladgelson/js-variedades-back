package jsvariedades.sales.dto.common;

import jsvariedades.sales.dto.response.SaleItemResponse;
import jsvariedades.sales.enums.SaleStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class SaleDTO {

    private Long id;

    private SaleStatus status;

    private Set<PaymentTypeDTO> paymentTypes;

    private String obs;

    private BigDecimal total;

    private Long storeId;

    private List<SaleItemResponse> items;

    public LocalDateTime getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public SaleDTO setLastUpdatedDate(LocalDateTime lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
        return this;
    }

    private LocalDateTime lastUpdatedDate;

    public SaleStatus getStatus() {
        return status;
    }

    public SaleDTO setStatus(SaleStatus status) {
        this.status = status;
        return this;
    }

    public Set<PaymentTypeDTO> getPaymentTypes() {
        return paymentTypes;
    }

    public SaleDTO setPaymentTypes(Set<PaymentTypeDTO> paymentTypes) {
        this.paymentTypes = paymentTypes;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public SaleDTO setObs(String obs) {
        this.obs = obs;
        return this;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public SaleDTO setTotal(BigDecimal total) {
        this.total = total;
        return this;
    }

    public Long getStoreId() {
        return storeId;
    }

    public SaleDTO setStoreId(Long storeId) {
        this.storeId = storeId;
        return this;
    }

    public List<SaleItemResponse> getItems() {
        return items;
    }

    public SaleDTO setItems(List<SaleItemResponse> items) {
        this.items = items;
        return this;
    }

    public Long getId() {
        return id;
    }

    public SaleDTO setId(Long id) {
        this.id = id;
        return this;
    }

    @Override
    public String toString() {
        return "SaleDTO{" +
                "id=" + id +
                ", status=" + status +
                ", paymentTypes=" + paymentTypes +
                ", obs='" + obs + '\'' +
                ", total=" + total +
                ", storeId=" + storeId +
                ", items=" + items +
                ", lastUpdatedDate=" + lastUpdatedDate +
                '}';
    }
}

package jsvariedades.sales.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class FinishSaleRequest {
    @NotEmpty
    private List<String> paymentTypes;
    @NotNull
    private String obs;

    public List<String> getPaymentTypes() {
        return paymentTypes;
    }

    public FinishSaleRequest setPaymentTypes(List<String> paymentTypes) {
        this.paymentTypes = paymentTypes;
        return this;
    }

    public String getObs() {
        return obs;
    }

    public FinishSaleRequest setObs(String obs) {
        this.obs = obs;
        return this;
    }

    @Override
    public String toString() {
        return "FinishSaleRequest{" +
                "paymentTypes=" + paymentTypes +
                ", obs='" + obs + '\'' +
                '}';
    }
}

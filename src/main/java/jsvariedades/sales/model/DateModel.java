package jsvariedades.sales.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;

@Embeddable
public class DateModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -8379140358162252399L;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    public DateModel() {
    }

    public DateModel(LocalDateTime createdDate, LocalDateTime updatedDate) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }

    public DateModel(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public LocalDateTime getInputDate() {
        return this.createdDate;
    }

    public void setInputDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getLastUpdatedDate() {
        return this.updatedDate;
    }

    public void setLastUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}

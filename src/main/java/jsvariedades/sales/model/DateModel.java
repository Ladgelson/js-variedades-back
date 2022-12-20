package jsvariedades.sales.model;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DateModel implements Serializable {
    @Serial
    private static final long serialVersionUID = -8379140358162252399L;

    @Column(nullable = false, name = "created_date")
    private LocalDateTime createdDate;

    @Column(nullable = false, name = "updated_date")
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

    public LocalDateTime getUpdatedDate() {
        return this.updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }
}

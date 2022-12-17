package jsvariedades.sales.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jsvariedades.sales.util.TimeZones;
import org.springframework.data.annotation.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 4769823595867830152L;
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private DateModel dateModel;

    public BaseModel() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DateModel getDateModel() {
        return this.dateModel;
    }

    public void setDateModel(DateModel dateModel) {
        this.dateModel = dateModel;
    }

    @PrePersist
    public void initializeDates() {
        LocalDateTime now = LocalDateTime.now(TimeZones.getDefault());
        this.dateModel = new DateModel(now, now);
    }

    @PreUpdate
    public void updateLastUpdatedDate() {
        this.dateModel.setUpdatedDate(LocalDateTime.now(TimeZones.getDefault()));
    }
}
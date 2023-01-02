package jsvariedades.sales.model.base;

import jakarta.persistence.*;
import jsvariedades.sales.util.TimeZones;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 4769823595867830152L;

    @Id
    @GeneratedValue
    @Column(nullable = false, name = "id")
    private Long id;
    @Embedded
    private DateModel dateModel;

    public BaseModel() {
    }

    public Long getId() {
        return this.id;
    }

    public DateModel getDateModel() {
        return this.dateModel;
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
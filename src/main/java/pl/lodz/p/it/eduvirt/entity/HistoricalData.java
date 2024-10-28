package pl.lodz.p.it.eduvirt.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.context.SecurityContextHolder;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;

@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
public class HistoricalData extends Updatable {

    @Column(name = DatabaseConstants.CREATED_BY, updatable = false)
    private UUID createdBy;

    @Column(name = DatabaseConstants.UPDATED_BY)
    private UUID updatedBy;

    @Column(name = DatabaseConstants.CREATED_AT, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime createdAt;

    @Column(name = DatabaseConstants.UPDATED_AT)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime updatedAt;

    // Constructors

    public HistoricalData(Long version) {
        super(version);
    }

    // Other methods

    @PrePersist
    public void changeCreateData() {
        //TODO: Change it later, when authentication is implemented (to put user's id in the context as well)
        this.createdBy = (UUID) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    @PreUpdate
    public void changeUpdateData() {
        //TODO: Change it later, when authentication is implemented (to put user's id in the context as well)
        this.updatedBy = (UUID) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }
}

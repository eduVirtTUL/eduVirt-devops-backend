package pl.lodz.p.it.eduvirt.entity.reservation;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.it.eduvirt.entity.HistoricalData;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = DatabaseConstants.RESERVATION_TABLE)
@Getter @Setter
@NoArgsConstructor
public class Reservation extends HistoricalData {

    @Column(name = DatabaseConstants.RESERVATION_RESOURCE_GROUP_ID, nullable = false, updatable = false)
    private UUID resourceGroupId;

    @Column(name = DatabaseConstants.RESERVATION_TEAM_ID, nullable = false, updatable = false)
    private UUID teamId;

    @Column(name = DatabaseConstants.RESERVATION_START, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime startTime;

    @Column(name = DatabaseConstants.RESERVATION_END, nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private OffsetDateTime endTime;

    @Column(name = DatabaseConstants.RESERVATION_AUTOMATIC_STARTUP, nullable = false)
    private Boolean automaticStartup = true;

    // Constructors

    public Reservation(UUID resourceGroupId,
                       UUID teamId,
                       OffsetDateTime startTime,
                       OffsetDateTime endTime,
                       Boolean automaticStartup) {
        this.resourceGroupId = resourceGroupId;
        this.teamId = teamId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.automaticStartup = automaticStartup;
    }

    @Builder
    public Reservation(Long version,
                       OffsetDateTime startTime,
                       OffsetDateTime endTime,
                       Boolean automaticStartup) {
        //super(version);
        this.startTime = startTime;
        this.endTime = endTime;
        this.automaticStartup = automaticStartup;
    }
}

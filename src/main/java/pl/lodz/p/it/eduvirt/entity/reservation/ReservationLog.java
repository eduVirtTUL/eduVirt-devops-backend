package pl.lodz.p.it.eduvirt.entity.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.it.eduvirt.entity.reservation.keys.ReservationLogKey;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.util.UUID;

@Entity
@Table(
        name = DatabaseConstants.RESERVATION_AUDIT_LOG_TABLE,
        indexes = {
            @Index(name = DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID_IDX,
                    columnList = DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID)
        },
        uniqueConstraints = @UniqueConstraint(name = DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID_EVENT_ID_UNIQUE,
                columnNames = {DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID, DatabaseConstants.RESERVATION_AUDIT_LOG_EVENT_ID})
)
@IdClass(ReservationLogKey.class)
@Getter @Setter
@NoArgsConstructor
public class ReservationLog {

    @Id
    @ManyToOne
    @JoinColumn(
            name = DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID,
            referencedColumnName = DatabaseConstants.PK,
            foreignKey = @ForeignKey(name = DatabaseConstants.RESERVATION_AUDIT_LOG_RESERVATION_ID_FK),
            nullable = false, updatable = false
    )
    private Reservation reservation;

    @Id
    @Column(name = DatabaseConstants.RESERVATION_AUDIT_LOG_EVENT_ID, nullable = false, updatable = false)
    private UUID eventId;
}

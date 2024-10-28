package pl.lodz.p.it.eduvirt.entity.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.it.eduvirt.entity.general.Metric;
import pl.lodz.p.it.eduvirt.entity.reservation.keys.ClusterMetricKey;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.util.UUID;

@Entity
@Table(
        name = DatabaseConstants.CLUSTER_METRIC_TABLE,
        indexes = {
            @Index(name = DatabaseConstants.CLUSTER_METRIC_METRIC_ID_IDX,
                    columnList = DatabaseConstants.CLUSTER_METRIC_METRIC_ID)
        },
        uniqueConstraints = @UniqueConstraint(name = DatabaseConstants.CLUSTER_METRIC_CLUSTER_ID_METRIC_ID_UNIQUE,
                columnNames = {DatabaseConstants.CLUSTER_METRIC_CLUSTER_ID, DatabaseConstants.CLUSTER_METRIC_METRIC_ID})
)
@IdClass(ClusterMetricKey.class)
@Getter @Setter
@NoArgsConstructor
public class ClusterMetric {

    @Id
    @Column(name = DatabaseConstants.CLUSTER_METRIC_CLUSTER_ID, nullable = false, updatable = false)
    private UUID clusterId;

    @Id
    @ManyToOne
    @JoinColumn(
            name = DatabaseConstants.CLUSTER_METRIC_METRIC_ID,
            referencedColumnName = DatabaseConstants.PK,
            foreignKey = @ForeignKey(name = DatabaseConstants.CLUSTER_METRIC_METRIC_ID_FK),
            nullable = false, updatable = false
    )
    private Metric metric;

    @Column(name = DatabaseConstants.CLUSTER_METRIC_VALUE)
    private Double value;

    // Constructors

    public ClusterMetric(UUID clusterId,
                         Metric metric,
                         Double value) {
        this.clusterId = clusterId;
        this.metric = metric;
        this.value = value;
    }
}

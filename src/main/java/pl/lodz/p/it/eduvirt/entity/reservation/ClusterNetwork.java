package pl.lodz.p.it.eduvirt.entity.reservation;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pl.lodz.p.it.eduvirt.entity.reservation.keys.ClusterNetworkKey;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.util.UUID;

@Entity
@Table(name = DatabaseConstants.CLUSTER_NETWORK_TABLE)
@IdClass(ClusterNetworkKey.class)
@Getter @Setter
public class ClusterNetwork {

    @Id
    @Column(name = DatabaseConstants.CLUSTER_NETWORK_CLUSTER_ID, nullable = false, updatable = false)
    private UUID clusterId;

    @Id
    @Column(name = DatabaseConstants.CLUSTER_NETWORK_NETWORK_ID, nullable = false, updatable = false)
    private UUID networkId;
}

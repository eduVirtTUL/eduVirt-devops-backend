package pl.lodz.p.it.eduvirt.entity.eduvirt.network;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "vnic_profile_pool")
@Getter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class VnicProfilePool {

    //TODO: Consider adding ONLY _created_at and _created_by

    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private UUID id;

    @Version
    @Column(name = "version", nullable = false)
    private Long version;

    @Setter
    @Column(name = "in_use", nullable = false)
    private Boolean inUse = false;

    public VnicProfilePool(UUID id,
                           Boolean inUse) {
        this.id = id;
        this.inUse = inUse;
    }
}

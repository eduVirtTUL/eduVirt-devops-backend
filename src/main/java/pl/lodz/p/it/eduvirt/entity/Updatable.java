package pl.lodz.p.it.eduvirt.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

@MappedSuperclass
@Getter
@NoArgsConstructor
public class Updatable extends AbstractEntity {

    @Version
    @Column(name = DatabaseConstants.VERSION, nullable = false)
    private Long version;

    // Constructors

    public Updatable(Long version) {
        this.version = version;
    }
}

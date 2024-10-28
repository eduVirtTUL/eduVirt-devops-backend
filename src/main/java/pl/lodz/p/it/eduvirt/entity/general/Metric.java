package pl.lodz.p.it.eduvirt.entity.general;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.lodz.p.it.eduvirt.entity.AbstractEntity;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

@Entity
@Table(name = DatabaseConstants.METRIC_TABLE)
@Getter @Setter
@NoArgsConstructor
public class Metric extends AbstractEntity {

    @Column(name = DatabaseConstants.METRIC_NAME, nullable = false, unique = true, length = 64)
    private String name;
}

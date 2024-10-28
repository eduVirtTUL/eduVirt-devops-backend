package pl.lodz.p.it.eduvirt.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import pl.lodz.p.it.eduvirt.util.consts.DatabaseConstants;

import java.util.UUID;

@MappedSuperclass
@Getter @ToString
@EqualsAndHashCode
@NoArgsConstructor
public class AbstractEntity {

    @Id
    @Column(name = DatabaseConstants.PK, nullable = false, unique = true, updatable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
}

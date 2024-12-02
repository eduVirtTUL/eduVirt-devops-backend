package pl.lodz.p.it.eduvirt.repository.eduvirt;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.lodz.p.it.eduvirt.entity.eduvirt.PodStateful;

import java.util.UUID;

public interface PodStatefulRepository extends JpaRepository<PodStateful, UUID> {

}

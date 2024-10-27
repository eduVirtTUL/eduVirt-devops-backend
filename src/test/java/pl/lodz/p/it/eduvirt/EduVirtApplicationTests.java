package pl.lodz.p.it.eduvirt;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.types.Vm;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lodz.p.it.eduvirt.util.ConnectionFactory;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@SpringBootTest
@RequiredArgsConstructor
class EduVirtApplicationTests {

    private final ConnectionFactory connectionFactory;

    @Test
    void testConnectionFactory() {
        List<Vm> vms = new ArrayList<>();
        try (Connection connection = connectionFactory.getConnection()) {
            vms = connection
                    .systemService()
                    .vmsService()
                    .list()
                    .send()
                    .vms();
        } catch (Throwable e) {
            log.error("Error occurred {}", e.getMessage());
        }

        for (Vm vm : vms) {
            System.out.printf("VM - %s: %s - (nic1 - %s)%n", vm.id(), vm.name(),
                    !vm.nics().isEmpty() ? String.format("%s - %s", vm.nics().getFirst().vnicProfile().id(),
                            vm.nics().getFirst().vnicProfile().name()) : null
            );
        }
    }
}

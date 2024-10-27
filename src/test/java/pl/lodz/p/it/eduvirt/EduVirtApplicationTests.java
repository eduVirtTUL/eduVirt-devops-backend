package pl.lodz.p.it.eduvirt;

import org.junit.jupiter.api.Test;
import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.types.Vm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lodz.p.it.eduvirt.utils.connection.EngineConnectionFactory;

import java.util.List;

@SpringBootTest
class EduVirtApplicationTests {

    @Autowired
    EngineConnectionFactory engineConnectionFactory;

    @Test
    void contextLoads() {
        List<Vm> vms;
        try (Connection connection = engineConnectionFactory.createConnection()) {

            vms = connection
                    .systemService()
                    .vmsService()
                    .list()
                    .send()
                    .vms();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (Vm vm : vms) {
            System.out.printf("VM - %s: %s - (nic1 - %s)%n", vm.id(), vm.name(),
                    !vm.nics().isEmpty() ? String.format("%s - %s", vm.nics().getFirst().vnicProfile().id(),
                            vm.nics().getFirst().vnicProfile().name()) : null
            );
        }
    }

}

package pl.lodz.p.it.eduvirt.controller;

import lombok.RequiredArgsConstructor;
import org.ovirt.engine.sdk4.Connection;
import org.ovirt.engine.sdk4.services.ClusterService;
import org.ovirt.engine.sdk4.services.ClustersService;
import org.ovirt.engine.sdk4.services.HostsService;
import org.ovirt.engine.sdk4.services.SystemService;
import org.ovirt.engine.sdk4.types.Cluster;
import org.ovirt.engine.sdk4.types.Host;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.it.eduvirt.dto.ClusterGeneralDto;
import pl.lodz.p.it.eduvirt.dto.HostDto;
import pl.lodz.p.it.eduvirt.dto.NetworkDto;
import pl.lodz.p.it.eduvirt.exceptions.ClusterNotFoundException;
import pl.lodz.p.it.eduvirt.mappers.ClusterMapper;
import pl.lodz.p.it.eduvirt.mappers.HostMapper;
import pl.lodz.p.it.eduvirt.mappers.NetworkMapper;
import pl.lodz.p.it.eduvirt.util.connection.ConnectionFactory;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/clusters")
@RequiredArgsConstructor
@Transactional(propagation = Propagation.NEVER)
public class ClusterController {

    private final ClusterMapper clusterMapper;
    private final NetworkMapper networkMapper;
    private final ConnectionFactory connectionFactory;

    // Read methods

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findClusterById(@PathVariable("id") UUID clusterId) {
        try {
            SystemService systemService = connectionFactory.getConnection().systemService();
            ClusterService clusterService = systemService.clustersService().clusterService(clusterId.toString());
            Cluster cluster = clusterService.get().send().cluster();
            return ResponseEntity.ok(clusterMapper.ovirtClusterToDetailsDto(cluster));
        } catch (org.ovirt.engine.sdk4.Error error) {
            throw new ClusterNotFoundException();
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAllClusters() {
        SystemService systemService = connectionFactory.getConnection().systemService();
        ClustersService clustersService = systemService.clustersService();
        List<ClusterGeneralDto> listOfDTOs = clustersService.list().send().clusters().stream()
                .map(clusterMapper::ovirtClusterToGeneralDto).toList();
        if (listOfDTOs.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(listOfDTOs);
    }

    @GetMapping(path = "/{id}/hosts", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findCpuInfoByClusterId(@PathVariable("id") UUID clusterId) {
        try {
            Connection connection =  connectionFactory.getConnection();
            SystemService systemService = connection.systemService();
            ClusterService clusterService = systemService.clustersService().clusterService(clusterId.toString());
            Cluster cluster = clusterService.get().send().cluster();
            HostsService hostsService = systemService.hostsService();
            List<Host> foundHosts = hostsService.list().search("cluster=" + cluster.name()).send().hosts();
            List<HostDto> listOfDTOs = foundHosts.stream().map(host -> HostMapper.ovirtHostToDto(host, cluster)).toList();
            if (listOfDTOs.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(listOfDTOs);
        } catch (org.ovirt.engine.sdk4.Error error) {
            throw new ClusterNotFoundException();
        }
    }

    @GetMapping(path = "/{id}/networks", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findNetworksByClusterId(@PathVariable("id") UUID clusterId) {
        try {
            Connection connection =  connectionFactory.getConnection();
            SystemService systemService = connection.systemService();
            ClusterService clusterService = systemService.clustersService().clusterService(clusterId.toString());
            Cluster cluster = clusterService.get().send().cluster();
            List<NetworkDto> listOfDTOs = connection.followLink(cluster.networks())
                    .stream().map(networkMapper::ovirtNetworkToDto).toList();
            if (listOfDTOs.isEmpty()) return ResponseEntity.noContent().build();
            return ResponseEntity.ok(listOfDTOs);
        } catch (org.ovirt.engine.sdk4.Error error) {
            throw new ClusterNotFoundException();
        }
    }
}

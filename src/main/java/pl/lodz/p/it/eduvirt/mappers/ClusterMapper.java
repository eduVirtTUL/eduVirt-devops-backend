package pl.lodz.p.it.eduvirt.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.ovirt.engine.sdk4.types.Cluster;
import pl.lodz.p.it.eduvirt.dto.ClusterDetailsDto;
import pl.lodz.p.it.eduvirt.dto.ClusterGeneralDto;

@Mapper(componentModel = "spring")
public interface ClusterMapper {

    @Mapping(target = "id", expression = "java(cluster.id())")
    @Mapping(target = "name", expression = "java(cluster.name())")
    ClusterGeneralDto ovirtClusterToGeneralDto(Cluster cluster);

    @Mapping(target = "id", expression = "java(cluster.id())")
    @Mapping(target = "name", expression = "java(cluster.name())")
    @Mapping(target = "description", expression = "java(cluster.description())")
    @Mapping(target = "comment", expression = "java(cluster.comment())")
    ClusterDetailsDto ovirtClusterToDetailsDto(Cluster cluster);
}

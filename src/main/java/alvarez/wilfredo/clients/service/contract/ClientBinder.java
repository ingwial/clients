package alvarez.wilfredo.clients.service.contract;

import alvarez.wilfredo.clients.service.contract.to.ClientTO;
import alvarez.wilfredo.clients.service.datasource.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientBinder {
    ClientBinder CLIENT_BINDER = Mappers.getMapper( ClientBinder.class );

    Client bind(ClientTO source);

    ClientTO bind(Client source);

    @Mapping(target = "id", ignore = true)
    Client bind(@MappingTarget Client target, ClientTO source);
}

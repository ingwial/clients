package alvarez.wilfredo.clients.service.datasource;

import alvarez.wilfredo.clients.service.datasource.entity.Client;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository("clientRepository")
public interface ClientRepository extends R2dbcRepository<Client, Long> {
}

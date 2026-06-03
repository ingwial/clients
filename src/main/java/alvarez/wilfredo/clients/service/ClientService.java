package alvarez.wilfredo.clients.service;

import alvarez.wilfredo.clients.service.contract.to.ClientTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Flux<ClientTO> getClients();
    Mono<ClientTO> getClient(Long id);
    Mono<ClientTO> updateClient(Long id, ClientTO clientTO);
    Mono<Void> deleteClient( Long id );
    Mono<ClientTO> createClient( ClientTO clientTO );
}

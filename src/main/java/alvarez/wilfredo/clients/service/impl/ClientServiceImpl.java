package alvarez.wilfredo.clients.service.impl;

import alvarez.wilfredo.clients.service.ClientService;
import alvarez.wilfredo.clients.service.contract.to.ClientTO;
import alvarez.wilfredo.clients.service.datasource.ClientRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static alvarez.wilfredo.clients.service.contract.ClientBinder.CLIENT_BINDER;

@Service("clientServiceImpl")
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Flux<ClientTO> getClients() {
        return this.clientRepository.findAll()
                .map(CLIENT_BINDER::bind);
    }

    @Override
    public Mono<ClientTO> getClient(Long id) {
        return this.clientRepository.findById(id)
                .map(CLIENT_BINDER::bind);
    }

    @Override
    public Mono<ClientTO> updateClient(Long id, ClientTO clientTO) {
        return this.clientRepository.findById(id)
                .map(client -> CLIENT_BINDER.bind(client, clientTO))
                .flatMap(this.clientRepository::save)
                .map(CLIENT_BINDER::bind);
    }

    @Override
    public Mono<Void> deleteClient(Long id) {
        return this.clientRepository.deleteById(id);
    }

    @Override
    public Mono<ClientTO> createClient(ClientTO clientTO) {
        return this.clientRepository.save(CLIENT_BINDER.bind(clientTO))
                .map(CLIENT_BINDER::bind);
    }
}

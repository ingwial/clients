package alvarez.wilfredo.clients.dist.rest;

import alvarez.wilfredo.clients.service.ClientService;
import alvarez.wilfredo.clients.service.contract.to.ClientTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<Flux<ClientTO>> findAll() {
        return ResponseEntity.ok(this.clientService.getClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<ClientTO>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(this.clientService.getClient(id));
    }

    @PostMapping
    public ResponseEntity<Mono<ClientTO>> create(@RequestBody ClientTO clientTO) {
        return ResponseEntity.ok(this.clientService.createClient(clientTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<ClientTO>> update(@PathVariable Long id, @RequestBody ClientTO clientTO) {
        return ResponseEntity.ok(this.clientService.updateClient(id, clientTO));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Mono<Void>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.clientService.deleteClient(id));
    }
}

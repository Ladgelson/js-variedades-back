package jsvariedades.sales.controller.v1.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.controller.v1.ClientController;
import jsvariedades.sales.dto.request.ClientRequest;
import jsvariedades.sales.dto.response.ClientResponse;
import jsvariedades.sales.mapper.ClienteMapper;
import jsvariedades.sales.model.ClientModel;
import jsvariedades.sales.service.ClienteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
public class ClientControllerImpl implements ClientController {

    private final ClienteService clienteService;

    public ClientControllerImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> createClient(ClientRequest client) {
        var id = clienteService.createClient(client).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }

    @Override
    @LogExecution
    public ResponseEntity<ClientResponse> findById(Long id) {
        var cliente = clienteService.findById(id);
        return ResponseEntity.ok(ClienteMapper.clienteModelToClientResponse(cliente));
    }

    @Override
    @LogExecution
    public ResponseEntity<Page<ClientResponse>> findAllPaginated(Pageable pageable) {
        var page = clienteService.findAllPaginated(pageable);
        return ResponseEntity.ok(page);
    }

    @Override
    @LogExecution
    public ResponseEntity<ClientResponse> updateClient(Long id, ClientRequest client) {
        var cliente = clienteService.updateClient(id, ClienteMapper.clienteRequestToClienteModel(client));
        return ResponseEntity.ok(ClienteMapper.clienteModelToClientResponse(cliente));
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> inactivateClient(Long id) {
        clienteService.inactivateClient(id);
        return ResponseEntity.ok().build();
    }
}

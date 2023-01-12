package jsvariedades.sales.controller.v1.impl;

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

    private final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);

    private final ClienteService clienteService;

    public ClientControllerImpl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @Override
    public ResponseEntity<Void> createClient(ClientRequest client) {
        logger.info("m=createClint stage=init clientRequest={}", client);
        var id = clienteService.createClient(client).getId();
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        logger.info("m=createClint stage=finish");
        return ResponseEntity.created(uri).build();
    }

    @Override
    public ResponseEntity<ClientResponse> findById(Long id) {
        logger.info("m=findById stage=init id={}",id);
        var cliente = clienteService.findById(id);
        logger.info("m=createClint stage=finish");
        return ResponseEntity.ok(ClienteMapper.clienteModelToClientResponse(cliente));
    }

    @Override
    public ResponseEntity<Page<ClientResponse>> findAllPaginated(Pageable pageable) {
        logger.info("m=findAllPaginated stage=init");
        var page = clienteService.findAllPaginated(pageable);
        logger.info("m=findAllPaginated stage=finish");
        return ResponseEntity.ok(page);
    }

    @Override
    public ResponseEntity<ClientResponse> updateClient(Long id, ClientModel client) {
        logger.info("m=updateClient stage=init id={} client={}", id, client);
        var cliente = clienteService.updateClient(id, client);
        logger.info("m=updateClient stage=finish");
        return ResponseEntity.ok(ClienteMapper.clienteModelToClientResponse(cliente));
    }

    @Override
    public ResponseEntity<Void> inactivateClient(Long id) {
        logger.info("m=inactivateClient stage=init idParaInativar={}", id);
        clienteService.inactivateClient(id);
        logger.info("m=inactivateClient stage=finish");
        return ResponseEntity.ok().build();
    }
}

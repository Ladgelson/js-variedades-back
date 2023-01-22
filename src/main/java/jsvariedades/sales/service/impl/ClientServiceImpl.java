package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.dto.request.ClientRequest;
import jsvariedades.sales.dto.response.ClientResponse;
import jsvariedades.sales.enums.ClientStatus;
import jsvariedades.sales.mapper.ClienteMapper;
import jsvariedades.sales.model.ClientModel;
import jsvariedades.sales.repository.ClientRepository;
import jsvariedades.sales.service.ClienteService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClienteService {

    private final Logger logger = LoggerFactory.getLogger(ClientServiceImpl.class);

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @LogExecution
    public ClientModel createClient(ClientRequest client) {
        return clientRepository.save(ClienteMapper.clienteRequestToClienteModel(client));
    }

    @Override
    @LogExecution
    public ClientModel findById(Long id) {
        return clientRepository.findById(id).orElseThrow( () -> {
            logger.info("m=findById stage=error id={}", id);
            return new ObjectNotFoundException("Error: Cliente não encontrada.", id);
        });
    }

    @Override
    @LogExecution
    public Page<ClientResponse> findAllPaginated(Pageable pageable) {
        return clientRepository.findAll(pageable).map(ClienteMapper::clienteModelToClientResponse);
    }

    @Override
    @LogExecution
    public ClientModel updateClient(Long id, ClientModel client) {
        var newClient = findById(id);
        updateData(newClient, client);
        return clientRepository.save(newClient);
    }

    @Override
    @LogExecution
    public void inactivateClient(Long id) {
        var client = findById(id);
        inativar(client);
    }

    @LogExecution
    public void updateData(ClientModel c1, ClientModel c2){
        c1.setName(c2.getName())
          .setEmail(c2.getEmail())
          .setPhone(c2.getPhone());
    }

    @LogExecution
    public void inativar(ClientModel clientModel){
        clientModel.setStatus(ClientStatus.BLOCKED);
    }

}

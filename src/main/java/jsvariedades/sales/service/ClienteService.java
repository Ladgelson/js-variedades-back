package jsvariedades.sales.service;

import jsvariedades.sales.dto.request.ClientRequest;
import jsvariedades.sales.dto.response.ClientResponse;
import jsvariedades.sales.model.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

public interface ClienteService {

    ClientModel createClient(@RequestBody @Validated ClientRequest client);

    ClientModel findById(@PathVariable Long id);

    Page<ClientResponse> findAllPaginated(Pageable pageable);

    ClientModel updateClient(@PathVariable Long id, @RequestBody ClientModel client);

    void inactivateClient(@PathVariable Long id);

}

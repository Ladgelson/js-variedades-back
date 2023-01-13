package jsvariedades.sales.controller.v1;

import jsvariedades.sales.dto.request.ClientRequest;
import jsvariedades.sales.dto.response.ClientResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/clients")
public interface ClientController {
    @PostMapping
    ResponseEntity<Void> createClient(@RequestBody @Validated ClientRequest client);

    @GetMapping("/{id}")
    ResponseEntity<ClientResponse> findById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<Page<ClientResponse>> findAllPaginated(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<ClientResponse> updateClient(@PathVariable Long id, @RequestBody ClientRequest client);

    @PostMapping("/{id}/inactivate")
    ResponseEntity<Void> inactivateClient(@PathVariable Long id);
}

package jsvariedades.sales.controller.v1;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/v1/clients")
public interface ClientController {
    @PostMapping
    ResponseEntity<?> createClient(@RequestBody Object client);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable String id);

    @GetMapping
    ResponseEntity<?> findAllPaginated(Pageable pageable);

    @PutMapping("/{id}")
    ResponseEntity<?> updateClient(@PathVariable String id, @RequestBody Object client);

    @PostMapping("/{id}/inactivate")
    ResponseEntity<?> inactivateClient(@PathVariable String id);
}

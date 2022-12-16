package jsvariedades.sales.controller.v1;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/produts")
public interface ProductController {
    @PostMapping
    ResponseEntity<?> saveProduct(@RequestBody Object product);

    @GetMapping
    ResponseEntity<?> findAllPaginated(Pageable pageable);

    @GetMapping
    ResponseEntity<?> findMostLikedPaginated(Pageable pageable);

    @GetMapping
    ResponseEntity<?> findLikedByUserPaginated(Pageable pageable, @RequestHeader("user-id") int userId);

    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable int id);

    @GetMapping("/{id}/liked-by/{userId}")
    ResponseEntity<?> likeProduct(@PathVariable int id, @PathVariable int userId);

    @PostMapping("/{id}/categories/{categId}")
    ResponseEntity<?> associateCategory(@PathVariable int id, @PathVariable int categId);
}

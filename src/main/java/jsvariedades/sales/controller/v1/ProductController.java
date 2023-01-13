package jsvariedades.sales.controller.v1;

import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/produts")
public interface ProductController {

    String USER_ID = "user-id";

    @PostMapping
    ResponseEntity<Void> saveProduct(@RequestBody ProductRequest product);

    @GetMapping
    ResponseEntity<Page<ProductResponse>> findAllPaginated(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction);

//    @GetMapping
    ResponseEntity<Page<ProductResponse>> findMostLikedPaginated(Pageable pageable);

//    @GetMapping
    ResponseEntity<Page<ProductResponse>> findLikedByUserPaginated(Pageable pageable, @RequestHeader(USER_ID) Long userId);

    @GetMapping("/{id}")
    ResponseEntity<ProductDTO> findById(@PathVariable Long id);

    @GetMapping("/{id}/liked-by/{userId}")
    ResponseEntity<Void> likeProduct(@PathVariable Long id, @PathVariable Long userId);

    @PostMapping("/{id}/categories/{categId}")
    ResponseEntity<Void> associateCategory(@PathVariable Long id, @PathVariable Long categId);
}

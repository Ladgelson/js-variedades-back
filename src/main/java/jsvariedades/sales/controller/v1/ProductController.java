package jsvariedades.sales.controller.v1;

import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/products")
@CrossOrigin(origins = "*", maxAge = 3600)
public interface ProductController {

    String USER_ID = "user-id";

    @PostMapping
    ResponseEntity<Void> saveProduct(@RequestBody ProductRequest product);

    @GetMapping
    ResponseEntity<Page<ProductResponse>> findAllPaginated(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long categoryId,
            @RequestParam(required = false) Boolean sortValueAsc,
            @RequestParam(required = false) Boolean sortFrequency);

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

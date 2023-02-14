package jsvariedades.sales.controller.v1.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.controller.v1.ProductController;
import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.mapper.ProductMapper;
import jsvariedades.sales.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> saveProduct(ProductRequest product) {
        var produto = ProductMapper.productModelToProductRequest(product);
        productService.saveProduct(produto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Page<ProductResponse>> findAllPaginated(int page, String name, Long categoryId, Boolean sortValueAsc, Boolean sortFrequencyAsc) {
        var res = productService.findAllPaginated(page, name, categoryId, sortValueAsc, sortFrequencyAsc);
        return ResponseEntity.ok(res);
    }

    @Override
    @LogExecution
    public ResponseEntity<Page<ProductResponse>> findMostLikedPaginated(Pageable pageable) {
        var products = productService.findMostLikedPaginated(pageable);
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<Page<ProductResponse>> findLikedByUserPaginated(Pageable pageable, Long userId) {
        // TODO has to be done
        return null;
    }

    @Override
    public ResponseEntity<Void> likeProduct(Long id, Long userId) {
        return null;
    }

    @Override
    @LogExecution
    public ResponseEntity<ProductDTO> findById(Long id) {
        var product = productService.findById(id);
        return ResponseEntity.ok(ProductMapper.productDtoToProductModel(product));
    }

    @Override
    @LogExecution
    public ResponseEntity<Void> associateCategory(Long id, Long categId) {
        productService.assiciateCategory(id,categId);
        return ResponseEntity.ok().build();
    }
}

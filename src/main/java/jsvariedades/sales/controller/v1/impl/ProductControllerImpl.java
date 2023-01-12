package jsvariedades.sales.controller.v1.impl;

import jsvariedades.sales.controller.v1.ProductController;
import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.mapper.ProductMapper;
import jsvariedades.sales.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductControllerImpl implements ProductController {

    private final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);

    private final ProductService productService;

    public ProductControllerImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ResponseEntity<Void> saveProduct(ProductRequest product) {
        logger.info("m=saveProduct stage=init product={}", product);
        var produto = ProductMapper.productModelToProductRequest(product);
        productService.saveProduct(produto);
        logger.info("m=saveProduct stage=finish");
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Page<ProductResponse>> findAllPaginated(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
            @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
            @RequestParam(value = "direction", defaultValue = "ASC") String direction) {
        logger.info("m=saveProduct stage=init page={} linesPerPage={} orderBy={} direction={}", page, linesPerPage, orderBy, direction);
        var productsPage = productService.findAllPaginated(page,linesPerPage,orderBy,direction);
        logger.info("m=saveProduct stage=finish");
        return ResponseEntity.ok(productsPage);
    }

    @Override
    public ResponseEntity<Page<ProductResponse>> findMostLikedPaginated(Pageable pageable) {
        logger.info("m=findMostLikedPaginated stage=init");
        var products = productService.findMostLikedPaginated(pageable);
        logger.info("m=findMostLikedPaginated stage=finish");
        return ResponseEntity.ok(products);
    }

    @Override
    public ResponseEntity<Page<ProductResponse>> findLikedByUserPaginated(Pageable pageable, Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> likeProduct(Long id, Long userId) {
        return null;
    }

    @Override
    public ResponseEntity<ProductDTO> findById(Long id) {
        logger.info("m=findById stage=init id={}", id);
        var product = productService.findById(id);
        logger.info("m=findById stage=finish");
        return ResponseEntity.ok(ProductMapper.productDtoToProductModel(product));
    }

    @Override
    public ResponseEntity<Void> associateCategory(Long id, Long categId) {
        logger.info("m=associateCategory stage=init id={} categId={}", id, categId);
        productService.assiciateCategory(id,categId);
        logger.info("m=associateCategory stage=init");
        return ResponseEntity.ok().build();
    }
}

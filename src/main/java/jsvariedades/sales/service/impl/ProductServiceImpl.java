package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.mapper.ProductMapper;
import jsvariedades.sales.model.ClientModel;
import jsvariedades.sales.model.ProductModel;
import jsvariedades.sales.repository.ProductRepository;
import jsvariedades.sales.service.CategoryService;
import jsvariedades.sales.service.ProductService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    private final CategoryService categoryService;


    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    @Override
    @LogExecution
    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> {
            logger.error("m=findById stage=error id={}", id);
            return new ObjectNotFoundException("error", id);
        });
    }

    @Override
    @LogExecution
    public void assiciateCategory(Long id, Long idCategory) {
        logger.info("m=assiciateCategory stage=init id={} categoryId={}", id, idCategory);
        var category = categoryService.findById(idCategory);
        var product = findById(id);
        logger.info("m=assiciateCategory stage=finish");
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    @LogExecution
    public void likeProduct(Long id, Long userId) {
//      Entity user not create.
    }

    @Override
    @LogExecution
    public Page<ProductResponse> findLikedByUserPaginated(Pageable pageable, Long userId) {
//      Entity user not create.
        return null;
    }

    @Override
    @LogExecution
    public Page<ProductResponse> findMostLikedPaginated(Pageable pageable) {
        logger.info("m=findMostLikedPaginated stage=init");
        return productRepository.findAll(pageable).map(ProductMapper::productModelToProductResponse);
    }

    @Override
    @LogExecution
    public Page<ProductResponse> findAllPaginated(Integer page, Integer linesPerPage, String orderBy, String direction) {
        logger.info("m=findAllPaginated stage=init page={} linesPerPage={} orderBy={} direction={}", page, linesPerPage, orderBy, direction);
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return productRepository.findAll(pageRequest).map(ProductMapper::productModelToProductResponse);
    }

    @Override
    @LogExecution
    public ProductModel saveProduct(ProductModel product) {
        logger.info("m=saveProduct stage=init product={}", product);
        return productRepository.save(product);
    }
}

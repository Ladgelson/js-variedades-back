package jsvariedades.sales.service.impl;

import jsvariedades.sales.config.logging.LogExecution;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.mapper.ProductMapper;
import jsvariedades.sales.model.LikeModel;
import jsvariedades.sales.model.ProductModel;
import jsvariedades.sales.repository.ProductRepository;
import jsvariedades.sales.service.CategoryService;
import jsvariedades.sales.service.LikeService;
import jsvariedades.sales.service.ProductService;
import jsvariedades.sales.service.UserService;
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

    private final UserService userService;

    private final LikeService likeService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, UserService userService, LikeService likeService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.likeService = likeService;
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
        var category = categoryService.findById(idCategory);
        var product = findById(id);
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    @LogExecution
    public void likeProduct(Long id, Long userId) {
        var product = findById(id);
        var user = userService.findById(userId);
        var like = new LikeModel().setUser(user).setProductModel(product);
        likeService.save(like);
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
        return productRepository.findAll(pageable).map(ProductMapper::productModelToProductResponse);
    }

    @Override
    @LogExecution
    public Page<ProductResponse> findAllPaginated(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page,linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return productRepository.findAll(pageRequest).map(ProductMapper::productModelToProductResponse);
    }

    @Override
    @LogExecution
    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }
}

package jsvariedades.sales.service.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

//    @Autowired
//    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

    @PersistenceContext
    private EntityManager entityManager;

//    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, UserService userService, LikeService likeService) {
//        this.productRepository = productRepository;
//        this.categoryService = categoryService;
//        this.userService = userService;
//        this.likeService = likeService;
//    }

    @Override
    @LogExecution
    public ProductModel findById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> {
//            logger.error("m=findById stage=error id={}", id);
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
    public Page<ProductResponse> findAllPaginated(int page, String name, Long categoryId, Boolean sortValueAsc, Boolean sortFrequency) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ProductModel> query = cb.createQuery(ProductModel.class);
        Root<ProductModel> product = query.from(ProductModel.class);
        query.select(product);

        if(name != null) {
            query.where(cb.like(product.get("name"), "%" + name + "%"));
        }
        if(categoryId != null) {
            product.join("category");
        }
        if(sortValueAsc != null) {
            if(sortValueAsc) {
                query.orderBy(cb.asc(product.get("saleValue")));
            } else {
                query.orderBy(cb.desc(product.get("saleValue")));
            }
        }
        if(sortFrequency != null) {
            if(sortFrequency) {
                query.orderBy(cb.asc(product.get("frequency")));
            } else {
                query.orderBy(cb.desc(product.get("frequency")));
            }
        }
        TypedQuery<ProductModel> typedQuery = entityManager.createQuery(query)
                .setMaxResults(3)
                .setFirstResult(page*3);
        return new PageImpl<>(typedQuery.getResultList())
                .map(ProductMapper::productModelToProductResponse);
    }

    @Override
    @LogExecution
    public ProductModel saveProduct(ProductModel product) {
        return productRepository.save(product);
    }
}

package jsvariedades.sales.service;

import jsvariedades.sales.dto.common.ProductDTO;
import jsvariedades.sales.dto.request.ProductRequest;
import jsvariedades.sales.dto.response.ProductResponse;
import jsvariedades.sales.model.ProductModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import static jsvariedades.sales.controller.v1.ProductController.USER_ID;

public interface ProductService {


    ProductModel findById(Long id);

    void assiciateCategory(Long id, Long idCategory);

    void likeProduct(Long id, Long userId);

    Page<ProductResponse> findLikedByUserPaginated(Pageable pageable, @RequestHeader(USER_ID) Long userId);

    Page<ProductResponse> findMostLikedPaginated(Pageable pageable);

    Page<ProductResponse> findAllPaginated(Integer page, Integer linesPerPage, String orderBy, String direction);

    ProductModel saveProduct(@RequestBody ProductModel product);
}

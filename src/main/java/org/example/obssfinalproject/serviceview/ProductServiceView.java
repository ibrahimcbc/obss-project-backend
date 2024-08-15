package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.dto.productDto.ProductWriteDto;
import org.example.obssfinalproject.model.products.Product;

import java.util.List;
import java.util.Optional;

public interface ProductServiceView {
    List<ProductReadDto> getAllProducts();

    List<ProductReadDto> sortByPrice(String order);

    List<ProductReadDto> sortByAverageScore(String order);

    Optional<ProductReadDto> getProductById(Long id);

    List<ProductReadDto> findByUserId(Long userId);

    void deleteAllProducts();

    List<ProductReadDto> searchProducts(String keyword);

    ProductReadDto createProduct(ProductWriteDto productWriteDto, Long userId);

    List<ProductReadDto> getFilteredProducts(Long userId);
}

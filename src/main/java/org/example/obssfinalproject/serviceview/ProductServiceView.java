package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;

import java.util.List;
import java.util.Optional;

public interface ProductServiceView {
    List<ProductReadDto> getAllProducts();

    List<ProductReadDto> sortByPrice(String order);

    List<ProductReadDto> sortByAverageScore(String order);

    Optional<ProductReadDto> getProductById(Long id);

    void deleteAllProducts();

    List<ProductReadDto> searchProducts(String keyword);
}

package org.example.obssfinalproject.serviceview;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;

import java.util.List;

public interface ProductServiceView {
    List<ProductReadDto> getAllProducts();

    void deleteAllProducts();

    List<ProductReadDto> searchProducts(String keyword);
}

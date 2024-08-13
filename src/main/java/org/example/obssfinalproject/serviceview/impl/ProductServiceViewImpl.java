package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.mapper.ProductMapper;
import org.example.obssfinalproject.service.ProductService;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceViewImpl implements ProductServiceView {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Override
    public List<ProductReadDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toProductReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAllProducts() {
        productService.deleteAllProducts();
    }

    @Override
    public List<ProductReadDto> searchProducts(String keyword) {
        return productService.searchProducts(keyword).stream()
                .map(productMapper::toProductReadDto)
                .collect(Collectors.toList());
    }
}

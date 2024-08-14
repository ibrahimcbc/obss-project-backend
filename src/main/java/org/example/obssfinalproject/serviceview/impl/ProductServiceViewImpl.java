package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.mapper.ProductMapper;
import org.example.obssfinalproject.repository.ProductRepository;
import org.example.obssfinalproject.service.ProductService;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceViewImpl implements ProductServiceView {

    @Autowired
    ProductService productService;

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<ProductReadDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(productMapper::toProductReadDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductReadDto> sortByPrice(String order) {
        if ("asc".equalsIgnoreCase(order)) {
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "price"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        } else {
            return productRepository.findAll(Sort.by(Sort.Direction.DESC, "price"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        }
    }

    @Override
    public List<ProductReadDto> sortByAverageScore(String order) {
        if ("asc".equalsIgnoreCase(order)) {
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "averageScore"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        } else {
            return productRepository.findAll(Sort.by(Sort.Direction.DESC, "averageScore"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        }
    }

    @Override
    public Optional<ProductReadDto> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toProductReadDto);
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

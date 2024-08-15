package org.example.obssfinalproject.serviceview.impl;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.dto.productDto.ProductWriteDto;
import org.example.obssfinalproject.exception.ResourceNotFoundException;
import org.example.obssfinalproject.mapper.ProductMapper;
import org.example.obssfinalproject.model.User;
import org.example.obssfinalproject.model.products.Book;
import org.example.obssfinalproject.model.products.Product;
import org.example.obssfinalproject.repository.ProductRepository;
import org.example.obssfinalproject.repository.UserRepository;
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

    @Autowired
    UserRepository userRepository;

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
            return productRepository.findAll(Sort.by(Sort.Direction.ASC, "score"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        } else {
            return productRepository.findAll(Sort.by(Sort.Direction.DESC, "score"))
                    .stream().map(productMapper::toProductReadDto).collect(Collectors.toList());
        }
    }

    @Override
    public Optional<ProductReadDto> getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toProductReadDto);
    }

    @Override
    public List<ProductReadDto> findByUserId(Long userId) {
        return productMapper.toProductReadDtoList(productRepository.findByUserId(userId));
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

    @Override
    public ProductReadDto createProduct(ProductWriteDto productWriteDto, Long userId) {
        Product product = productMapper.toProduct(productWriteDto);
        Product createdBook = productService.createProduct(product, userId);
        return productMapper.toProductReadDto(createdBook);    }

    @Override
    public List<ProductReadDto> getFilteredProducts(Long userId) {
        List<Product> products = productService.getFilteredProducts(userId);
        return products.stream()
                .map(productMapper::toProductReadDto)
                .collect(Collectors.toList());
    }
}

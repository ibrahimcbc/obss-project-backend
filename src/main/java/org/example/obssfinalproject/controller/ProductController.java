package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductServiceView productServiceView;

    @GetMapping()
    public List<ProductReadDto> getAllProducts() {
        return productServiceView.getAllProducts();
    }

    @GetMapping("/search/{keyword}")
    public List<ProductReadDto> searchProducts(String keyword) {
        return productServiceView.searchProducts(keyword);
    }

    @DeleteMapping()
    public void deleteAllProducts() {
        productServiceView.deleteAllProducts();
    }
}

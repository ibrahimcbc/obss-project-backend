package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

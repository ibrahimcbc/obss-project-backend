package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/sort")
    public List<ProductReadDto> sortProducts(@RequestParam String sortBy, @RequestParam String order) {
        if ("price".equals(sortBy)) {
            return productServiceView.sortByPrice(order);
        } else if ("averageScore".equals(sortBy)) {
            return productServiceView.sortByAverageScore(order);
        } else {
            throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReadDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.of(productServiceView.getProductById(id));
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

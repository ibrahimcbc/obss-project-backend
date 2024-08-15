package org.example.obssfinalproject.controller;

import org.example.obssfinalproject.dto.productDto.ProductReadDto;
import org.example.obssfinalproject.dto.productDto.ProductWriteDto;
import org.example.obssfinalproject.dto.userDto.UserReadDto;
import org.example.obssfinalproject.model.products.Product;
import org.example.obssfinalproject.service.ProductService;
import org.example.obssfinalproject.serviceview.ProductServiceView;
import org.example.obssfinalproject.serviceview.UserServiceView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductServiceView productServiceView;

    @Autowired
    UserServiceView userServiceView;

    @Autowired
    ProductService productService;

    @PostMapping("/{userId}")
    public ProductReadDto addProduct(@RequestBody ProductWriteDto productWriteDto, @PathVariable Long userId) {
        return productServiceView.createProduct(productWriteDto, userId);
    }

    @GetMapping()
    public List<ProductReadDto> getAllProducts() {
        return productServiceView.getAllProducts();
    }

    @GetMapping("/sort")
    public List<ProductReadDto> sortProducts(@RequestParam String sortBy, @RequestParam String order) {
        if ("price".equals(sortBy)) {
            return productServiceView.sortByPrice(order);
        } else if ("score".equals(sortBy)) {
            return productServiceView.sortByAverageScore(order);
        } else {
            throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductReadDto> getProductById(@PathVariable Long id) {
        return ResponseEntity.of(productServiceView.getProductById(id));
    }

    @GetMapping("/users/{userId}")
    public List<ProductReadDto> getProductsByUserId(@PathVariable Long userId) {
        return productServiceView.findByUserId(userId);
    }


    @GetMapping("/search/{keyword}")
    public List<ProductReadDto> searchProducts(String keyword) {
        return productServiceView.searchProducts(keyword);
    }

    @DeleteMapping()
    public void deleteAllProducts() {
        productServiceView.deleteAllProducts();
    }

    @GetMapping("/filtered")
    public ResponseEntity<List<ProductReadDto>> getFilteredProducts(@RequestParam Long userId) {
        List<ProductReadDto> products = productServiceView.getFilteredProducts(userId);
        return ResponseEntity.ok(products);
    }
}

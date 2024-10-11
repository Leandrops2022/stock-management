package com.example.stock_management.controller;

import com.example.stock_management.domain.product.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductSummaryDTO> registerProduct(@RequestBody @Valid RegisterProductDTO productDTO) {
        var product = productService.createProduct(productDTO);
        var uri = UriComponentsBuilder.fromPath("/products/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductSummaryDTO(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductPresentationDTO>> listProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getProducts().stream()
                .map(ProductPresentationDTO::new)
                .toList());
    }
}

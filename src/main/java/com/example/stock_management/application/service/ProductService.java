package com.example.stock_management.application.service;

import com.example.stock_management.domain.product.Product;
import com.example.stock_management.domain.product.ProductRepository;
import com.example.stock_management.application.dto.product.RegisterProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public Product createProduct(RegisterProductDTO registerProductDTO) {
        return repository.save(new Product(registerProductDTO));
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }
}

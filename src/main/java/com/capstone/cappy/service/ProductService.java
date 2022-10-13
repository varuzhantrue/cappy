package com.capstone.cappy.service;

import com.capstone.cappy.models.Product;
import com.capstone.cappy.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(Long id) {
        return productRepository.getReferenceById(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public List<Product> findTop6() {
        return productRepository.findTop6ByOrderById();//implements automatically
    }

    public List<Product> search(String keyword) {
        return productRepository.findAllByNameContainsIgnoreCase(keyword);
    }
}

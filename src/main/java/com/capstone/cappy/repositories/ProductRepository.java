package com.capstone.cappy.repositories;

import com.capstone.cappy.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findTop6ByOrderById();

    List<Product> findAllByNameContainsIgnoreCase(String keyword);

}

package com.capstone.cappy.controllers;

import com.capstone.cappy.entities.Product;
import com.capstone.cappy.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

//    @GetMapping("/productPage")
//    public String page(Model model) {
//        Product product = productService.getProductById(106L);
//        model.addAttribute("product", product);
//        return "productPage";
//    }

    @GetMapping("/product")
    public String product(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product";
    }

    @GetMapping("/productPage/{id}")
    public String page(Model model, @PathVariable Long id) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "productPage";
    }
}

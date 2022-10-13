package com.capstone.cappy.controllers;

import com.capstone.cappy.models.Product;
import com.capstone.cappy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller//API
public class MainController {
    @Autowired
    private final ProductService productService;

    public MainController(ProductService productService) {
        this.productService = productService;
    }


//    @GetMapping("/")
//    public String home() {
//        return "index";
//    }

    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = productService.findTop6();
        model.addAttribute("productList", productList);
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
    @GetMapping("/search")
    public String search(@RequestParam String keyword, Model model)
    {
        model.addAttribute("productList",productService.search(keyword));
        return "product";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }
}

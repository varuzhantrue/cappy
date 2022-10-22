package com.capstone.cappy.controllers;

import com.capstone.cappy.auth.UserDetailsImpl;
import com.capstone.cappy.entities.History;
import com.capstone.cappy.entities.Product;
import com.capstone.cappy.entities.User;
import com.capstone.cappy.service.HistoryService;
import com.capstone.cappy.service.ProductService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Controller
public class HistoryController {
    private final ProductService productService;
    private final HistoryService historyService;

    public HistoryController(ProductService productService, HistoryService historyService) {
        this.productService = productService;
        this.historyService = historyService;
    }

    @GetMapping("/history")
    public String history(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        User user = userDetails.getUser();
        List<History> historyList = historyService.findAllByUserId(user.getId());
        model.addAttribute("historyList", historyList);
        return "history";
    }


    @GetMapping("/download/{productId}")
    public String downloadFIle(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long productId, HttpServletResponse response) throws IOException {

        if (userDetails == null) {
            return "redirect:/login";
        }

        User user = userDetails.getUser();
        Product product = productService.getProductById(productId);

        productService.downloadProduct(product.getId(), response);
        History history = new History(
                user.getId(),
                productId,
                LocalDate.now(),
                product.getName());
        historyService.save(history);
        return "redirect:/product";
    }
}

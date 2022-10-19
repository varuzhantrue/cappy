package com.capstone.cappy.controllers;

import com.capstone.cappy.entities.Product;
import com.capstone.cappy.entities.User;
import com.capstone.cappy.entities.UserDto;
import com.capstone.cappy.service.ProductService;
import com.capstone.cappy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller//API
public class MainController {
    @Autowired
    private final ProductService productService;
    private final UserService userService;

    public MainController(ProductService productService, UserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

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
    public String search(@RequestParam String keyword, Model model) {
        model.addAttribute("productList", productService.search(keyword));
        return "product";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/user/registration")
    public String showRegistrationForm(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "registrationPage";
    }

    @PostMapping("/user/registration/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        Optional<User> existingUser = userService.findUserByEmail(userDto.getEmail());
        System.out.println(userDto);
        if(existingUser.isPresent()){
            System.out.println("user exists");
            result.rejectValue("email", "404",
                    "Another account is using the same email.");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "registrationPage";
        }
        userService.registerUser(userDto);
        return "redirect:/login";
    }
}

package com.capstone.cappy.controllers;

import com.capstone.cappy.models.User;
import com.capstone.cappy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserApiController {
    private final UserService userService;

    @Autowired
    public UserApiController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")//?
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }

    @DeleteMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")//?
    public void removeUser(@PathVariable("userId") Long userId) {
        userService.removeUser(userId);
    }

    @PutMapping(path = "{userId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")//?
    public void updateUser(
            @PathVariable("userId") Long userId,
            @RequestParam(required = false) String password,
            @RequestParam(required = false) String firstName,
            @RequestParam(required = false) String lastName,
            @RequestParam(required = false) String number,
            @RequestParam(required = false) String dateOfBirth) {

        LocalDate ld = null;
        if (dateOfBirth != null) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            ld = LocalDate.parse(dateOfBirth, formatter);
        }
        userService.updateUser(userId, password, firstName, lastName, number, ld);
    }
}

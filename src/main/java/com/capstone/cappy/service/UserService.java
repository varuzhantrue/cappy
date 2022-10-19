package com.capstone.cappy.service;

import com.capstone.cappy.entities.User;
import com.capstone.cappy.entities.UserDto;
import com.capstone.cappy.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service//component
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getUsers() {
        return userRepository.findAllByOrderByIdAsc();
    }

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoleName(userDto.getRoleName());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setNumber(userDto.getNumber());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ld = LocalDate.parse(userDto.getDateOfBirth(), formatter);
        user.setDateOfBirth(ld);

        userRepository.save(user);
        System.out.println(user);
    }

    public void removeUser(Long userId) {
        boolean exists = userRepository.existsById(userId);
        if (exists) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalStateException("no user matched with id: " + userId);
        }
    }

    @Transactional
    public void updateUser(Long userId,
                           String password,
                           String firstName,
                           String lastName,
                           String number,
                           LocalDate dateOfBirth) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalStateException(
                        "no user matched with id: " + userId
                ));

        if (password != null
                && password.length() > 0
                && !password.equals(user.getPassword())) {
            user.setPassword(password);
        }

        if (firstName != null
                && firstName.length() > 0
                && !firstName.equals(user.getFirstName())) {
            user.setFirstName(firstName);
        }

        if (lastName != null
                && lastName.length() > 0
                && !lastName.equals(user.getLastName())) {
            user.setLastName(lastName);
        }

        if (number != null
                && number.length() > 0
                && !number.equals(user.getNumber())) {
            user.setNumber(number);
        }

        if (dateOfBirth != null && !dateOfBirth.equals(user.getDateOfBirth())) {
            user.setDateOfBirth(dateOfBirth);
        }
    }

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}

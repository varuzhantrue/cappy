package com.capstone.cappy.service;

import com.capstone.cappy.models.User;
import com.capstone.cappy.repositories.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service//component
public class UserService {
    //business logic
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAllByOrderByIdAsc();
    }

    public void registerUser(User user) {
        Optional<User> userOptional = userRepository
                .findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalStateException("e-mail is already registered");
        } else {
            userRepository.save(user);
        }
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

//        if (email != null
//                && email.length() > 0
//                && !email.equals(user.getEmail())) {
//            Optional<User> optionalUser = userRepository.findUserByEmail(email);
//            if (optionalUser.isPresent()) {
//                throw new IllegalStateException("e-mail taken");
//            }
//            user.setEmail(email);
//        }


    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}

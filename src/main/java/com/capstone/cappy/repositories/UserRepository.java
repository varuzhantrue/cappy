package com.capstone.cappy.repositories;

import com.capstone.cappy.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByEmail(String email);
    //SELECT email FROM users WHERE email = "email"

    List<User> findAllByOrderByIdAsc();

    boolean existsByEmail(String email);
}

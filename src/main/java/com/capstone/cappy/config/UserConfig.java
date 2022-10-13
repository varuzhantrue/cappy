//package com.capstone.cappy.config;
//
//import com.capstone.cappy.models.User;
//import com.capstone.cappy.repositories.UserRepository;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.time.LocalDate;
//import java.util.List;
//
//@Configuration
//public class UserConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(UserRepository repository) {
//        return args -> {
//            User Jerry = new User(
//                    "jerry@gmail.com",
//                    "tomandjerry",
//                    "Jerry",
//                    "Jerryson",
//                    "374-99-99-99-99",
//                    LocalDate.of(1940,1,1)
//            );
//
//            User Tom = new User(
//                    "Tom@gmail.com",
//                    "tomandjerry",
//                    "Tom",
//                    "Tomson",
//                    "374-99-99-99-99",
//                    LocalDate.of(1940,1,1)
//            );
//
//
//            repository.saveAll(
//                    List.of(Tom, Jerry)
//            );
//        };
//    }
//}
//

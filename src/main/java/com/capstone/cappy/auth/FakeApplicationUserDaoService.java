//package com.capstone.cappy.auth;
//
//import com.google.common.collect.Lists;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//import static com.capstone.cappy.enums.ROLES.ADMIN;
//import static com.capstone.cappy.enums.ROLES.USER;
//
//@Repository("fake")
//public class FakeApplicationUserDaoService implements ApplicationUserDao {
//
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder) {
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    @Override
//    public Optional<UserDetailsImpl> selectApplicationUserByUsername(String username) {
//        return getApplicationUsers()
//                .stream()
//                .filter((userDetailsImpl -> userDetailsImpl.getUsername().equals(username)))
//                .findFirst();
//    }
//
//    private List<UserDetailsImpl> getApplicationUsers() {
//        List<UserDetailsImpl> userDetailsImpls = Lists.newArrayList(
//                new UserDetailsImpl(
//                        "Tommy",
//                        passwordEncoder.encode("peakyBlinders"),
//                        ADMIN.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                ),
//                new UserDetailsImpl(
//                        "Arthur",
//                        passwordEncoder.encode("peakyBlinders"),
//                        USER.getGrantedAuthorities(),
//                        true,
//                        true,
//                        true,
//                        true
//                )
//        );
//        return userDetailsImpls;
//    }
//}

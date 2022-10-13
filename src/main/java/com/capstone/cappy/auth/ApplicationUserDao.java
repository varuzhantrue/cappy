package com.capstone.cappy.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    Optional<UserDetailsImpl> selectApplicationUserByUsername(String username);
}

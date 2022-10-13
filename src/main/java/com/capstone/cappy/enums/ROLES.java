package com.capstone.cappy.enums;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum ROLES {
    ADMIN(Sets.newHashSet(
            PERMISSIONS.GET_PRODUCTS,
            PERMISSIONS.GET_USERS,
            PERMISSIONS.POST_PRODUCTS,
            PERMISSIONS.POST_USERS,
            PERMISSIONS.DELETE_PRODUCTS,
            PERMISSIONS.DELETE_USERS,
            PERMISSIONS.PUT_PRODUCTS,
            PERMISSIONS.PUT_USERS)),
    USER(Sets.newHashSet(PERMISSIONS.GET_PRODUCTS));

    private final Set<PERMISSIONS> permissionsSet;

    ROLES(Set<PERMISSIONS> permissionsSet) {
        this.permissionsSet = permissionsSet;
    }

    public Set<PERMISSIONS> getPermissionsSet() {
        return permissionsSet;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> permissions =
                this.getPermissionsSet()
                        .stream()
                        .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                        .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}

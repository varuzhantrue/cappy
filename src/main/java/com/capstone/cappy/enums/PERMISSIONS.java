package com.capstone.cappy.enums;

public enum PERMISSIONS {
    GET_PRODUCTS("getProducts"),
    GET_USERS("getUsers"),
    POST_PRODUCTS("postProducts"),
    POST_USERS("postUsers"),
    DELETE_PRODUCTS("deleteProducts"),
    DELETE_USERS("deleteUsers"),
    PUT_PRODUCTS("putProducts"),
    PUT_USERS("putUsers");

    private final String permission;

    PERMISSIONS(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}

package com.example.api.entities.user;

public enum UserRole {
    ADMIN("admin"),
    BASIC("basic");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}

package com.example.api.entities.user;

public record RegisterDTO(String login, String password, UserRole role) {
}

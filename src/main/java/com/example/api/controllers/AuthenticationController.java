package com.example.api.controllers;

import com.example.api.entities.user.AuthenticationDTO;
import com.example.api.entities.user.AuthenticationResponseDTO;
import com.example.api.entities.user.RegisterDTO;
import com.example.api.entities.user.User;
import com.example.api.infra.security.TokenService;
import com.example.api.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var token = this.tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new AuthenticationResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Valid RegisterDTO dto) {
        User user = new User(dto.login(), new BCryptPasswordEncoder().encode(dto.password()), dto.role());

        this.userRepository.save(user);

        return ResponseEntity.ok().build();
    }
}

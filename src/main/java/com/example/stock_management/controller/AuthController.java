package com.example.stock_management.controller;

import com.example.stock_management.domain.user.NewUserDTO;
import com.example.stock_management.domain.user.User;
import com.example.stock_management.domain.user.UserCreationDTO;
import com.example.stock_management.infra.security.AuthService;
import com.example.stock_management.infra.security.JWTService;
import com.example.stock_management.infra.security.JwtDTO;
import com.example.stock_management.infra.security.LoginCredentialsDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<NewUserDTO> createUser(@RequestBody @Valid UserCreationDTO credentials) {
        var newUserDTO = authService.createUser(credentials);
        var uri = UriComponentsBuilder.fromPath("/users/{id}").buildAndExpand(newUserDTO.id()).toUri();
        return ResponseEntity.created(uri).body(newUserDTO);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@RequestBody @Valid LoginCredentialsDTO loginCredentialsDTO) {
        var authToken = new UsernamePasswordAuthenticationToken(loginCredentialsDTO.username(), loginCredentialsDTO.password());
        var authentication = manager.authenticate(authToken);
        var jwt = jwtService.createToken((User)authentication.getPrincipal());

        return ResponseEntity.ok(new JwtDTO(jwt));
    }


}

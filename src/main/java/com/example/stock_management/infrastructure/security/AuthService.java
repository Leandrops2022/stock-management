package com.example.stock_management.infrastructure.security;

import com.example.stock_management.application.dto.user.NewUserDTO;
import com.example.stock_management.domain.user.User;
import com.example.stock_management.application.dto.user.UserCreationDTO;
import com.example.stock_management.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }

    public NewUserDTO createUser(UserCreationDTO credentials) {
        var encodedPassword = passwordEncoder.encode(credentials.password());
        return new NewUserDTO(userRepository.save(new User(credentials.username(), encodedPassword)));
    }


}



package com.example.sweetshop.auth.service;

import com.example.sweetshop.auth.dto.LoginRequest;
import com.example.sweetshop.auth.dto.RegisterRequest;
import com.example.sweetshop.auth.model.User;
import com.example.sweetshop.auth.model.Role;
import com.example.sweetshop.auth.repository.UserRepository;
import com.example.sweetshop.config.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public String register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRole(Role.USER); // default role

        userRepository.save(user);

        return jwtService.generateToken(user);
    }

    public String login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow();

        return jwtService.generateToken(user);
    }

    public void makeAdmin(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setRole(Role.ADMIN);
        userRepository.save(user);
    }
}

package com.example.sweetshop.auth;

import com.example.sweetshop.auth.dto.RegisterRequest;
import com.example.sweetshop.auth.model.User;
import com.example.sweetshop.auth.repository.UserRepository;
import com.example.sweetshop.auth.service.AuthService;
import com.example.sweetshop.config.JwtService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AuthServiceTest {

    @Mock private UserRepository userRepository;
    @Mock private PasswordEncoder passwordEncoder;
    @Mock private JwtService jwtService;
    @Mock private AuthenticationManager authenticationManager;

    @InjectMocks private AuthService authService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterGeneratesToken() {
        RegisterRequest req = new RegisterRequest();
        req.setName("John");
        req.setEmail("john@example.com");
        req.setPassword("12345");

        User saved = new User();
        saved.setId(1L);

        when(passwordEncoder.encode("12345")).thenReturn("encoded123");
        when(userRepository.save(any(User.class))).thenReturn(saved);
        when(jwtService.generateToken(any(User.class))).thenReturn("mock-token");


        String result = authService.register(req);

        assertNotNull(result);
        assertEquals("mock-token", result);

        verify(userRepository, times(1)).save(any());
    }
}

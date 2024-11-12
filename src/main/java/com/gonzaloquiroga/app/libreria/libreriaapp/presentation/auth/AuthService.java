package com.gonzaloquiroga.app.libreria.libreriaapp.presentation.auth;

import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.enums.Role;
import com.gonzaloquiroga.app.libreria.libreriaapp.service.jwt.JwtService;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.entity.User;
import com.gonzaloquiroga.app.libreria.libreriaapp.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        UserDetails user = userRepository.findUserByUsername(request.getUsername()).orElseThrow();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .username(request.getUsername())
                .usersurname(request.getUsersurname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .country(request.getCountry())
                .district(request.getDistrict())
                .adress(request.getAdress())
                .pcode(request.getPcode())
                .role(Role.USER)
                .registeredAt(LocalDateTime.now())
                .build();
        userRepository.save(user);
        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}

package com.br.turbrasil.service;

import com.br.turbrasil.dto.request.AuthenticationRequest;
import com.br.turbrasil.dto.response.AuthenticationResponse;
import com.br.turbrasil.model.entity.User;
import com.br.turbrasil.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthenticationService {

    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email(), request.password()));

        return new AuthenticationResponse(jwtService.generateToken(authentication));
    }
}

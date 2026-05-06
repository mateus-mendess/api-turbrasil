package com.br.turbrasil.service;

import com.br.turbrasil.dto.request.UserRequest;
import com.br.turbrasil.dto.response.UserResponse;
import com.br.turbrasil.exception.EmailAlreadyExistsException;
import com.br.turbrasil.mapper.UserMapper;
import com.br.turbrasil.model.entity.User;
import com.br.turbrasil.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserResponse save(UserRequest request) {
        validate(request.email());

        User user = userMapper.toUser(request);

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return userMapper.toResponse(userRepository.save(user));
    }

    private void validate(String email) {
        if (userRepository.existsByEmail(email)) {
            throw new EmailAlreadyExistsException("Email already registered in the system.");
        }
    }
}

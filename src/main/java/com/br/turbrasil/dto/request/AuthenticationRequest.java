package com.br.turbrasil.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(
        @NotBlank(message = "The email cannot be empty.")
        @Email(message = "invalid email")
        String email,

        @NotBlank(message = "The password cannot be empty.")
        String password
) {}

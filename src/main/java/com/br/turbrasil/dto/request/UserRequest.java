package com.br.turbrasil.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserRequest(
        @NotBlank(message = "The name cannot be empty.")
        @Pattern(regexp = "^[A-Za-zÀ-ÖØ-öø-ÿ ]{2,100}$",
                message = "invalid name.")
        String name,

        @NotBlank(message = "The email cannot be empty.")
        @Email(message = "invalid email")
        String email,

        @NotBlank(message = "The password cannot be empty.")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z\\d]).{8,}$",
                message = "The password must contain at least 8 characters, including uppercase, lowercase, numbers, and special characters.")
        String password
) {}

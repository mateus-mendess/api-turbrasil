package com.br.turbrasil.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record CategoryRequest(
        @NotBlank(message = "The name cannot be empty.")
        @Pattern(regexp = "[A-Za-zÀ-ÖØ-öø-ÿ ]{2,100}$",
        message = "Invalid name")
        String name
) {}

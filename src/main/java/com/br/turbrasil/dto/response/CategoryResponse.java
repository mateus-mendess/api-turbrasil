package com.br.turbrasil.dto.response;

import java.util.UUID;

public record CategoryResponse(
        UUID id,
        String name
) {}

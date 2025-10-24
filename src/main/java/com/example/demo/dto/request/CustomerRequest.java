package com.example.demo.dto.request;

import jakarta.validation.constraints.NotBlank;

public record CustomerRequest (
        @NotBlank String firstName,
        @NotBlank String lastName
) {}

package com.demo.auth.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.jspecify.annotations.Nullable;

@Data
public class LoginRequest {
    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "password is required")
    private String password;
}
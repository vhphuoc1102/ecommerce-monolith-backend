package com.phuocvh.app.dtos.auth;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String emailOrPhone, @NotNull String password) {}

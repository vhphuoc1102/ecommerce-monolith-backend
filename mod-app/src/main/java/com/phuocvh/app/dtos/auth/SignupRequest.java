package com.phuocvh.app.dtos.auth;

import jakarta.validation.constraints.NotNull;

public record SignupRequest(@NotNull String email, @NotNull String password) {}

package com.phuocvh.app.dtos;

import jakarta.validation.constraints.NotNull;

public record LoginRequest(@NotNull String emailOrPhone,@NotNull String password) {}

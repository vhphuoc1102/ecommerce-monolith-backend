package com.phuocvh.app.dtos;

import jakarta.validation.constraints.NotNull;

public record SignupRequest (@NotNull String email,@NotNull String password) {}

package com.phuocvh.app.dtos;

import lombok.Getter;

@Getter
public record LoginRequest(String emailOrPhone, String password) {}

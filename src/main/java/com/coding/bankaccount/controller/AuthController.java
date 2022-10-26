package com.coding.bankaccount.controller;

import com.coding.bankaccount.dto.LoginRequestDto;
import com.coding.bankaccount.dto.TokenResponseDto;
import com.coding.bankaccount.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public TokenResponseDto login(@RequestBody LoginRequestDto loginRequestDto) {
      return authService.login(loginRequestDto);
    }
}

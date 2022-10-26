package com.coding.bankaccount.service;

import com.coding.bankaccount.dto.LoginRequestDto;
import com.coding.bankaccount.dto.TokenResponseDto;
import com.coding.bankaccount.security.TokenGenerator;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final CustomerService customerService;
    private final TokenGenerator tokenGenerator;
    private final AuthenticationManager authenticationManager;

    public AuthService(CustomerService customerService, TokenGenerator tokenGenerator, AuthenticationManager authenticationManager) {
        this.customerService = customerService;
        this.tokenGenerator = tokenGenerator;
        this.authenticationManager = authenticationManager;
    }

    public TokenResponseDto login(LoginRequestDto loginRequestDto) {
        try {
            Authentication auth =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
            return TokenResponseDto.builder()
                    .token(tokenGenerator.generate(auth))
                    .customerDto(customerService.getCustomer(loginRequestDto.getEmail()))
                    .build();
        } catch (Exception e) {
            throw new UsernameNotFoundException(loginRequestDto.getEmail());
        }
    }
}

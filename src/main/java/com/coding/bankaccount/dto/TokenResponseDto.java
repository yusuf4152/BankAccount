package com.coding.bankaccount.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenResponseDto {
    private String token;
    private GetCustomerDto customerDto;
}

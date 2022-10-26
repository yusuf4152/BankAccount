package com.coding.bankaccount.dto;


import com.coding.bankaccount.entity.Account;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreateTransactionDto {
    private LocalDateTime createdAt;

    @Min(value = 0,message = "miktar 0 dan küçük olamaz")
    private BigDecimal amount;
    @NotBlank(message = "account ıd bos birakılamaz")
    private String accountId;

    public CreateTransactionDto(LocalDateTime createdAt, BigDecimal amount, String accountId) {
        this.createdAt = createdAt;
        this.amount = amount;
        this.accountId = accountId;
    }

    public CreateTransactionDto() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}

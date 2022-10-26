package com.coding.bankaccount.dto;

import java.math.BigDecimal;

public class AccountArithmeticDto {
    private String accountId;
    private BigDecimal amount;

    public AccountArithmeticDto(String accountId, BigDecimal amount) {
        this.accountId = accountId;
        this.amount = amount;
    }

    public AccountArithmeticDto() {
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}

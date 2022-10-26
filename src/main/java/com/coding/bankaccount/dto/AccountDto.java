package com.coding.bankaccount.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class AccountDto {
    private String id;
    private BigDecimal balance;
    private String location;
    private LocalDate createdAt;

    public AccountDto(String id, BigDecimal balance, String location, LocalDate createdAt) {
        this.id = id;
        this.balance = balance;
        this.location = location;
        this.createdAt = createdAt;
    }
    public AccountDto() {
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}

package com.coding.bankaccount.dto;

import com.coding.bankaccount.entity.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class GetTransactionDto {
    private String id;
    private LocalDateTime createdAt;
    private BigDecimal amount;
    private AccountDto account;
    private TransactionType transactionType;

    public GetTransactionDto(String id, LocalDateTime createdAt, BigDecimal amount, AccountDto accountDto,TransactionType transactionType) {
        this.id = id;
        this.createdAt = createdAt;
        this.amount = amount;
        this.account = accountDto;
        this.transactionType=transactionType;
    }
    public GetTransactionDto() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public AccountDto getAccount() {
        return account;
    }

    public void setAccount(AccountDto accountDto) {
        this.account = accountDto;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }
}

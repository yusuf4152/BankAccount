package com.coding.bankaccount.dto;



import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.math.BigDecimal;


public class CreateAccountDto {

    private BigDecimal balance;

    @NotEmpty(message = "location bos bırakılamaz")
    @Size(min = 2,message = "loaksyon min 2 karakterden olusmalıdır")
    private String location;
    @NotNull(message = "customer id bos bırakılamaz")
    private String customerId;

    public CreateAccountDto(BigDecimal balance, String location, String customerId) {
        this.balance = balance;
        this.location = location;
        this.customerId = customerId;
    }

    public CreateAccountDto() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

}

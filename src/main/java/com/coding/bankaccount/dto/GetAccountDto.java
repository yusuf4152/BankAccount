package com.coding.bankaccount.dto;

import java.math.BigDecimal;
public class GetAccountDto {

    private String id;
    private BigDecimal balance;
    private String location;
    private GetCustomerDto customer;
    public GetAccountDto(String id, BigDecimal balance, String location, GetCustomerDto customerDto) {
        this.id = id;
        this.balance = balance;
        this.location = location;
        this.customer = customerDto;
    }
    public GetAccountDto() {
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

    public GetCustomerDto getCustomer() {
        return customer;
    }

    public void setCustomer(GetCustomerDto customerDto) {
        this.customer = customerDto;
    }
}

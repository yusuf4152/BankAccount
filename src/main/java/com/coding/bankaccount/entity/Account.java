package com.coding.bankaccount.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Account {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private BigDecimal balance;
    private String location;
    private LocalDate createdAt;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @JsonManagedReference
    @OneToMany(mappedBy = "account",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Transaction> transactions;


    public Account(String id, BigDecimal balance, String location, LocalDate createdAt, Customer customer, List<Transaction> transactions) {
        this.id = id;
        this.balance = balance;
        this.location = location;
        this.createdAt = createdAt;
        this.customer = customer;
        this.transactions = transactions;
    }

    public Account() {

    }

    public String getId() {
        return id;
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

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}














package com.coding.bankaccount.repository;

import com.coding.bankaccount.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,String> {

    public Optional<Customer> getCustomerByEmail(String email);
}

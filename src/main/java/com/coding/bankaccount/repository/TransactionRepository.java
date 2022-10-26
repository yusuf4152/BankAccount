package com.coding.bankaccount.repository;

import com.coding.bankaccount.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,String> {
}

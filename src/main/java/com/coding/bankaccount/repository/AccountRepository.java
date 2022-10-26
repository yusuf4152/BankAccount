package com.coding.bankaccount.repository;

import com.coding.bankaccount.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}

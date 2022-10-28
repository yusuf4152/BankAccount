package com.coding.bankaccount.service;

import com.coding.bankaccount.dto.AccountArithmeticDto;
import com.coding.bankaccount.dto.Converter.GetAccountDtoConverter;
import com.coding.bankaccount.dto.CreateAccountDto;
import com.coding.bankaccount.dto.GetAccountDto;
import com.coding.bankaccount.dto.TransferMoneyDto;
import com.coding.bankaccount.entity.Account;
import com.coding.bankaccount.entity.Transaction;
import com.coding.bankaccount.entity.TransactionType;
import com.coding.bankaccount.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerService customerService;
    private final GetAccountDtoConverter converter;

    public AccountService(AccountRepository accountRepository, CustomerService customerService, GetAccountDtoConverter converter) {
        this.accountRepository = accountRepository;
        this.customerService = customerService;
        this.converter = converter;
    }

    public GetAccountDto createAccount(CreateAccountDto createAccountDto) {
        Account account = new Account();
        account.setBalance(createAccountDto.getBalance());
        account.setLocation(createAccountDto.getLocation());
        account.setCustomer(customerService.getCustomerById(createAccountDto.getCustomerId()));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(
                LocalDateTime.now(),
                createAccountDto.getBalance(),
                account,
                TransactionType.INITIAL

        ));
        account.setTransactions(transactions);
        accountRepository.save(account);
        return converter.convert(account);
    }

    public GetAccountDto addMoney(AccountArithmeticDto accountArithmeticDto) {
        Account account = getAccountById(accountArithmeticDto.getAccountId());
        account.setBalance(account.getBalance().add(accountArithmeticDto.getAmount()));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(
                LocalDateTime.now(),
                accountArithmeticDto.getAmount(),
                account,
                TransactionType.ADD
        ));
        account.setTransactions(transactions);
        Account savedAccount = accountRepository.save(account);
        return converter.convert(savedAccount);
    }

    public GetAccountDto drawMoney(AccountArithmeticDto accountArithmeticDto) {
        Account account = getAccountById(accountArithmeticDto.getAccountId());
        account.setBalance(account.getBalance().subtract(accountArithmeticDto.getAmount()));
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction(
                LocalDateTime.now(),
                accountArithmeticDto.getAmount(),
                account,
                TransactionType.SUB
        ));
        account.setTransactions(transactions);
        Account savedAccount = accountRepository.save(account);
        return converter.convert(savedAccount);
    }

    public GetAccountDto deleteAccount(String accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(() -> new EntityNotFoundException(accountId + " " + "bulunamadı"));
        this.accountRepository.delete(account);
        return converter.convert(account);
    }

    protected Account getAccountById(String id) {

        return accountRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("account not found"));
    }

    @Transactional
    public TransferMoneyDto transferMoney(TransferMoneyDto transferMoneyDto) {
        Account senderAccount = getAccountById(transferMoneyDto.getSenderAccountId());
        Account receiverAccount = getAccountById(transferMoneyDto.getReceiverAccountId());
        senderAccount.setBalance(senderAccount.getBalance().subtract(transferMoneyDto.getAmount()));
        receiverAccount.setBalance(receiverAccount.getBalance().add(transferMoneyDto.getAmount()));
        return transferMoneyDto;
    }

    public List<GetAccountDto> getAccountList() {
        List<Account> accounts = accountRepository.findAll();
        return accounts.stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}

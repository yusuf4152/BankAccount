package com.coding.bankaccount.service;

import com.coding.bankaccount.dto.Converter.GetTransactionDtoConverter;
import com.coding.bankaccount.dto.CreateTransactionDto;
import com.coding.bankaccount.dto.GetTransactionDto;
import com.coding.bankaccount.entity.Transaction;
import com.coding.bankaccount.entity.TransactionType;
import com.coding.bankaccount.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final GetTransactionDtoConverter getTransactionDtoConverter;
    private final AccountService accountService;

    public TransactionService
            (TransactionRepository transactionRepository, GetTransactionDtoConverter getTransactionDtoConverter,
             AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.getTransactionDtoConverter = getTransactionDtoConverter;
        this.accountService = accountService;
    }

    public GetTransactionDto createTransaction(CreateTransactionDto createTransactionDto) {
        Transaction transaction = new Transaction();
        transaction.setCreatedAt(createTransactionDto.getCreatedAt());
        transaction.setAmount(createTransactionDto.getAmount());
        transaction.setAccount(accountService.getAccountById(createTransactionDto.getAccountId()));
        transaction.setTransactionType(TransactionType.INITIAL);
        transactionRepository.save(transaction);
        return getTransactionDtoConverter.convert(transaction);
    }

    public List<GetTransactionDto> getTransactionList() {
        return transactionRepository
                .findAll()
                .stream()
                .map(getTransactionDtoConverter::convert)
                .collect(Collectors.toList());

    }
}

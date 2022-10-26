package com.coding.bankaccount.controller;

import com.coding.bankaccount.dto.CreateTransactionDto;
import com.coding.bankaccount.dto.GetTransactionDto;
import com.coding.bankaccount.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/createTransaction")
    public ResponseEntity<GetTransactionDto> createTransaction(@Valid @RequestBody CreateTransactionDto createTransactionDto)
    {
        return ResponseEntity.ok(transactionService.createTransaction(createTransactionDto));
    }
    @GetMapping("/getTransactionList")
    public ResponseEntity<List<GetTransactionDto>> getTransactionList()
    {
        return ResponseEntity.ok(transactionService.getTransactionList());
    }
}

package com.coding.bankaccount.controller;

import com.coding.bankaccount.dto.AccountArithmeticDto;
import com.coding.bankaccount.dto.CreateAccountDto;
import com.coding.bankaccount.dto.GetAccountDto;
import com.coding.bankaccount.dto.TransferMoneyDto;
import com.coding.bankaccount.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/createAccount")
    public ResponseEntity<GetAccountDto> createAccount(@Valid @RequestBody CreateAccountDto createAccountDto) {
        return ResponseEntity.ok(accountService.createAccount(createAccountDto));
    }

    @GetMapping("/getAccountList")
    public ResponseEntity<List<GetAccountDto>> getAccountList() {
        return ResponseEntity.ok(accountService.getAccountList());
    }

    @PutMapping("/addMoney")
    public GetAccountDto addMoney(@RequestBody AccountArithmeticDto accountArithmeticDto) {
        return accountService.addMoney(accountArithmeticDto);
    }

    @DeleteMapping("/deleteAccount/{accountId}")
    public GetAccountDto deleteAccount(@PathVariable String accountId) {
        return accountService.deleteAccount(accountId);
    }

    @PutMapping("/drawMoney")
    public GetAccountDto drawMoney(@RequestBody AccountArithmeticDto accountArithmeticDto) {
        return accountService.drawMoney(accountArithmeticDto);
    }

    @PutMapping("/transferMoney")
    public TransferMoneyDto transferMoney(@RequestBody TransferMoneyDto transferMoneyDto) {
        return accountService.transferMoney(transferMoneyDto);
    }
}

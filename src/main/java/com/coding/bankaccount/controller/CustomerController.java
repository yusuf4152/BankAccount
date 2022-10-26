package com.coding.bankaccount.controller;

import com.coding.bankaccount.dto.CreateCustomerDto;
import com.coding.bankaccount.dto.GetCustomerDto;
import com.coding.bankaccount.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/createCustomer")
    public ResponseEntity<GetCustomerDto> createCustomer(@Valid @RequestBody CreateCustomerDto customerDto) {
        return ResponseEntity.ok(customerService.createCustomer(customerDto));
    }

    @GetMapping("/getCustomerList")
    public ResponseEntity<List<GetCustomerDto>> getCustomerList() {
        return ResponseEntity.ok(customerService.getCustomerList());
    }
}

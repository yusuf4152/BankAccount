package com.coding.bankaccount.dto.Converter;

import com.coding.bankaccount.dto.AccountDto;
import com.coding.bankaccount.dto.CreateTransactionDto;
import com.coding.bankaccount.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class CreateTransactionDtoConverter {

    public CreateTransactionDto convert(Transaction from) {
        return new CreateTransactionDto(
                from.getCreatedAt(),
                from.getAmount(),
                from.getAccount().getId()
        );
    }
}

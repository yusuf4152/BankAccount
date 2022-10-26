package com.coding.bankaccount.dto.Converter;

import com.coding.bankaccount.dto.AccountDto;
import com.coding.bankaccount.dto.GetTransactionDto;
import com.coding.bankaccount.entity.Transaction;
import org.springframework.stereotype.Component;

@Component
public class GetTransactionDtoConverter {
    public GetTransactionDto convert(Transaction from){
        return new GetTransactionDto(
                from.getId(),
                from.getCreatedAt(),
                from.getAmount(),
                new AccountDto(
                        from.getAccount().getId(),
                        from.getAccount().getBalance(),
                        from.getAccount().getLocation(),
                        from.getAccount().getCreatedAt()
                ),
                from.getTransactionType()
        );
    }
}

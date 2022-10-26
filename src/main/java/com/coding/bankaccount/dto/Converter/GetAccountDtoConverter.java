package com.coding.bankaccount.dto.Converter;

import com.coding.bankaccount.dto.GetAccountDto;
import com.coding.bankaccount.dto.GetCustomerDto;
import com.coding.bankaccount.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class GetAccountDtoConverter {
    public GetAccountDto convert(Account from) {
        return new GetAccountDto(
                from.getId(),
                from.getBalance(),
                from.getLocation(),
                new GetCustomerDto(
                        from.getCustomer().getId(),
                        from.getCustomer().getName(),
                        from.getCustomer().getSurName(),
                        from.getCustomer().getEmail(),
                        from.getCustomer().getRole()
                )
        );
    }
}

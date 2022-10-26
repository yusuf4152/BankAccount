package com.coding.bankaccount.dto.Converter;

import com.coding.bankaccount.dto.GetCustomerDto;
import com.coding.bankaccount.entity.Customer;
import org.springframework.stereotype.Component;

@Component
public class GetCustomerDtoConverter {
    public GetCustomerDto convert(Customer from){
        return  new GetCustomerDto(
                from.getId(),
                from.getName(),
                from.getSurName(),
                from.getEmail(),
                from.getRole()
        );
    }
}

package com.coding.bankaccount.dto.exception;
;
import lombok.Data;

import java.util.List;
@Data
public class EntityFieldExceptionDto {
    private int code;
    private List<String> errorList;
}

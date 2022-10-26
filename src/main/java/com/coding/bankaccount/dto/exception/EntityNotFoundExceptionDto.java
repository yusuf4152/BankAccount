package com.coding.bankaccount.dto.exception;

public class EntityNotFoundExceptionDto {
    private int code;
    private String message;

    public EntityNotFoundExceptionDto(int code, String message) {
        this.code = code;
        this.message = message;
    }
    public EntityNotFoundExceptionDto() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

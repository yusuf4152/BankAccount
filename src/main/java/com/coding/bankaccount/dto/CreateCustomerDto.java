package com.coding.bankaccount.dto;


import com.coding.bankaccount.entity.Role;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateCustomerDto {


    @Size(min = 2, max = 50, message = "name alanı min 2 max 50 karakterden oluşabilir")
    private String name;

    @Size(min = 2, max = 50, message = "soyad alanı min 3 karakter olmalıdır")
    private String surName;
    private Role role;

    @Email
    @NotNull(message = "email alanı boş bırakılamaz")
    private String email;

    @Size(min = 6)
    @NotNull(message = "sifre alanı bos bırakılamaz")
    private String password;

    public CreateCustomerDto(String name, String surName, Role role, String email, String password) {
        this.name = name;
        this.surName = surName;
        this.role = role;
        this.email = email;
        this.password = password;
    }

    public CreateCustomerDto(String name, String surName) {
        this.name = name;
        this.surName = surName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public CreateCustomerDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}

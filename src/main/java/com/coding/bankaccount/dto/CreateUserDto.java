package com.coding.bankaccount.dto;

import com.coding.bankaccount.entity.Role;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

public class CreateUserDto {

    @Email
    private String email;

    @Size(min = 6)
    private String password;

    private Role role;

    public CreateUserDto(String email, String password, Role role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public CreateUserDto() {
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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

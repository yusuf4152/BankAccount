package com.coding.bankaccount.dto;


import com.coding.bankaccount.entity.Role;

public class GetCustomerDto {
    private String id;
    private String name;
    private String surName;
    private String email;

    private Role role;

    public GetCustomerDto(String id, String name, String surName, String email, Role role) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.role = role;
    }

    public GetCustomerDto(String id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public GetCustomerDto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

package com.coding.bankaccount.security;

import com.coding.bankaccount.entity.Customer;
import com.coding.bankaccount.service.CustomerService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    private final CustomerService customerService;
    public UserDetailsService( CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Customer customer = customerService.findCustomerByEmail(username);
        List<SimpleGrantedAuthority> roles = Stream.of(customer.getRole())
                .map(role -> new SimpleGrantedAuthority(role.name())).collect(Collectors.toList());
        return new org.springframework.security.core.userdetails.User(customer.getEmail(), customer.getPassword(), roles);
    }
}


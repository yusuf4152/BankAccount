package com.coding.bankaccount.service;

import com.coding.bankaccount.dto.Converter.GetCustomerDtoConverter;
import com.coding.bankaccount.dto.CreateCustomerDto;
import com.coding.bankaccount.dto.GetCustomerDto;
import com.coding.bankaccount.entity.Customer;
import com.coding.bankaccount.entity.Role;
import com.coding.bankaccount.repository.CustomerRepository;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final GetCustomerDtoConverter getCustomerDtoConverter;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    public CustomerService(CustomerRepository customerRepository, GetCustomerDtoConverter getCustomerDtoConverter, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.customerRepository = customerRepository;
        this.getCustomerDtoConverter = getCustomerDtoConverter;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Customer findCustomerByEmail(String email){
       return customerRepository.getCustomerByEmail(email).orElseThrow(() ->  new UsernameNotFoundException(email));
    }
    public GetCustomerDto getCustomer(String email){
        Customer customer=findCustomerByEmail(email);
        return getCustomerDtoConverter.convert(customer);
    }

    public GetCustomerDto createCustomer(CreateCustomerDto customerDto) {
      Customer customer= new Customer();
      customer.setName(customerDto.getName());
      customer.setSurName(customerDto.getSurName());
      customer.setEmail(customerDto.getEmail());
      customer.setPassword(bCryptPasswordEncoder.encode(customerDto.getPassword()));
      if (customerDto.getRole()==null){
          customer.setRole(Role.USER);
      }
      else {
          customer.setRole(customerDto.getRole());
      }
      customerRepository.save(customer);
      return getCustomerDtoConverter.convert(customer);
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("customer not found"));
    }
    public List<GetCustomerDto> getCustomerList() {
        List<Customer> customers = customerRepository.findAll();
        return customers.stream().map(getCustomerDtoConverter::convert).collect(Collectors.toList());
    }
}

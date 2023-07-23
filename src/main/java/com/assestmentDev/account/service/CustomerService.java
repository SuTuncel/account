package com.assestmentDev.account.service;

import com.assestmentDev.account.dto.CustomerDto;
import com.assestmentDev.account.dto.CustomerDtoConverter;
import com.assestmentDev.account.exception.CustomerNotFoundException;
import com.assestmentDev.account.model.Customer;
import com.assestmentDev.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter converter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter converter) {
        this.customerRepository = customerRepository;
        this.converter = converter;
    }

    protected Customer findCustomerById(String id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException("Customer not found by id: "+ id));
    }

    public CustomerDto getCustomerById(String customerId) {
        return converter.convertToCustomerDto(findCustomerById(customerId));
    }
}

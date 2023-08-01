package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.CustomerDto;
import com.hasansahin.airlineticketingsystem.dto.converter.CustomerConverter;
import com.hasansahin.airlineticketingsystem.exception.GenericException;
import com.hasansahin.airlineticketingsystem.model.Customer;
import com.hasansahin.airlineticketingsystem.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerConverter customerConverter;

    public CustomerDto save(CustomerDto customerDto) {
        Customer customer = customerConverter.convertCustomerDtoToCustomer(customerDto);
        return customerConverter.convertCustomerToCustomerDto(customerRepository.save(customer));
    }

    protected Customer findByEmailProtected(String email) {
        return customerRepository.findByEmail(email).orElseThrow(() -> new GenericException("Customer not found", HttpStatus.NOT_FOUND));
    }
}

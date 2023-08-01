package com.hasansahin.airlineticketingsystem.service;

import com.hasansahin.airlineticketingsystem.dto.CustomerDto;
import com.hasansahin.airlineticketingsystem.dto.converter.CustomerConverter;
import com.hasansahin.airlineticketingsystem.model.Customer;
import com.hasansahin.airlineticketingsystem.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CustomerServiceTest {
    @Mock
    CustomerConverter customerConverter;

    @Mock
    CustomerRepository customerRepository;

    @InjectMocks
    CustomerService customerService;

    @Test
    void save() {
        Customer customer = new Customer("Hasan", "Şahin", "hasansahin@test.com");
        CustomerDto customerDto = new CustomerDto("Hasan", "Şahin", "hasansahin@test.com");

        when(customerRepository.save(customer)).thenReturn(customer);
        when(customerConverter.convertCustomerDtoToCustomer(customerDto)).thenReturn(customer);
        when(customerConverter.convertCustomerToCustomerDto(customer)).thenReturn(customerDto);

        CustomerDto resultCustomerDto = customerService.save(customerDto);

        assertEquals(customerDto.getEmail(), resultCustomerDto.getEmail());
    }
}

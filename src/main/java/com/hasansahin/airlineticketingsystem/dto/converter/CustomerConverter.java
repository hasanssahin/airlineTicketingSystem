package com.hasansahin.airlineticketingsystem.dto.converter;

import com.hasansahin.airlineticketingsystem.dto.CustomerDto;
import com.hasansahin.airlineticketingsystem.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerConverter {
	public Customer convertCustomerDtoToCustomer(CustomerDto customerDto){
		return new Customer(customerDto.getName(), customerDto.getSurname(), customerDto.getEmail());
	}
	public CustomerDto convertCustomerToCustomerDto(Customer customer){
		return new CustomerDto(customer.getName(), customer.getSurname(), customer.getEmail());
	}
}
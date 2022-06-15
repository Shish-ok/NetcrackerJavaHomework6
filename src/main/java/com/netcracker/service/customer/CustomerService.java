package com.netcracker.service.customer;

import com.netcracker.dto.customers.CustomersDistrictsDto;
import com.netcracker.dto.customers.SurnameAndDiscountDto;
import com.netcracker.dto.customers.UpdateCustomerDto;
import com.netcracker.model.Customer;

import java.util.List;

public interface CustomerService {

    CustomersDistrictsDto getCustomersDistrict();

    Customer addCustomer(Customer customer);

    List<Customer> getAllCustomers();

    Customer getById(int id);

    String deleteCustomerById(int id);

    String updateCustomer(int id, UpdateCustomerDto updateCustomerDto);

    String fullUpdateCustomer(int id, UpdateCustomerDto updateCustomerDto);

    List<SurnameAndDiscountDto> getCustomersSurnameAndDiscountByDistrict(String district);
}
package com.netcracker.service.customer;

import com.netcracker.dto.customers.CustomersDistrictsDto;
import com.netcracker.dto.customers.SurnameAndDiscountDto;
import com.netcracker.dto.customers.UpdateCustomerDto;
import com.netcracker.exception.ResourceNotFoundException;
import com.netcracker.model.Customer;
import com.netcracker.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private Customer customer;

    @Override
    public CustomersDistrictsDto getCustomersDistrict() {
        return new CustomersDistrictsDto(customerRepository.getCustomersDistricts());
    }

    @Override
    public List<SurnameAndDiscountDto> getCustomersSurnameAndDiscountByDistrict(String district) {
        System.out.println("Yes");
        return customerRepository.getCustomersSurnameAndDiscountByDistrict(district);
    }

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getById(int id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));
    }

    @Override
    public String deleteCustomerById(int id) {
        customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));
        customerRepository.deleteById(id);
        return "Customer " + customer.getSurname() + " (id:" + id + ") — successfully deleted!";
    }

    @Override
    public String updateCustomer(int id, UpdateCustomerDto updateCustomerDto) {
        customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));

        StringBuilder updateMessage = new StringBuilder();

        if (updateCustomerDto.getSurname() != null) {
            customerRepository.updateSurnameById(updateCustomerDto.getSurname(), id);
            updateMessage.append("Surname successfully updated: old surname \"" + customer.getSurname() + "\", new surname \"" + updateCustomerDto.getSurname() + "\"\n");
        }

        if (updateCustomerDto.getDistrict() != null) {
            customerRepository.updateDistrictById(updateCustomerDto.getDistrict(), id);
            updateMessage.append("District successfully updated: old district \"" + customer.getDistrict() + "\", new district \"" + updateCustomerDto.getDistrict() + "\"\n");
        }

        if (updateCustomerDto.getDiscount() != null) {
            customerRepository.updateDiscountById(updateCustomerDto.getDiscount(), id);
            updateMessage.append("Discount successfully updated: old discount \"" + customer.getDiscount() + "\", new discount \"" + updateCustomerDto.getDiscount() + "\"\n");
        }

        return updateMessage.toString();
    }

    @Override
    public String fullUpdateCustomer(int id, UpdateCustomerDto updateCustomerDto) {
        customer = customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not found customer with id: " + id));

        customer.setSurname(updateCustomerDto.getSurname());
        customer.setDistrict(updateCustomerDto.getDistrict());
        customer.setDiscount(updateCustomerDto.getDiscount());

        return "Customer with id: " + id + " — successfully update!";
    }
}
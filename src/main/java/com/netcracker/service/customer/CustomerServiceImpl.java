package com.netcracker.service.customer;

import com.netcracker.dto.customers.CustomersDistrictsDto;
import com.netcracker.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public CustomersDistrictsDto getCustomersDistrict() {
        return customerRepository.getCustomersDistricts();
    }

}
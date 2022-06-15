package com.netcracker.rest;

import com.netcracker.dto.customers.CustomersDistrictsDto;
import com.netcracker.dto.customers.DistrictDto;
import com.netcracker.dto.customers.SurnameAndDiscountDto;
import com.netcracker.dto.customers.UpdateCustomerDto;
import com.netcracker.model.Customer;
import com.netcracker.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Add new customer")
    @PostMapping("add")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.addCustomer(customer));
    }

    @Operation(summary = "Get all customers")
    @GetMapping("all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.ok(customerService.getAllCustomers());
    }
    
    @Operation(summary = "Get customer by id")
    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @Operation(summary = "Get all districts where customers live")
    @GetMapping("districts")
    public ResponseEntity<CustomersDistrictsDto> getDistricts() {
        return ResponseEntity.ok(customerService.getCustomersDistrict());
    }

    @Operation(summary = "Get customer's surnames and discounts by district")
    @GetMapping("discount_by_district/{district}")
    public ResponseEntity<List<SurnameAndDiscountDto>>getDiscountsByDistricts(@PathVariable(value = "district") String district) {
        return ResponseEntity.ok(customerService.getCustomersSurnameAndDiscountByDistrict(district));
    }

    @Operation(summary = "Partial customer update by id")
    @PatchMapping("update/{id}")
    public ResponseEntity<String> updateCustomer(@PathVariable(value = "id") int id, @RequestBody UpdateCustomerDto updateCustomerDto) {
        return ResponseEntity.ok(customerService.updateCustomer(id, updateCustomerDto));
    }

    @Operation(summary = "Full customer update by id")
    @PutMapping("full_update/{id}")
    public ResponseEntity<String> fullUpdateCustomer(@PathVariable(value = "id") int id, @RequestBody UpdateCustomerDto updateCustomerDto) {
        return ResponseEntity.ok(customerService.fullUpdateCustomer(id, updateCustomerDto));
    }

    @Operation(summary = "Delete customer by id")
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(customerService.deleteCustomerById(id));
    }
}
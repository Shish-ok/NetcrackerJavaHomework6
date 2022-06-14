package com.netcracker.rest;

import com.netcracker.dto.customers.CustomersDistrictsDto;
import com.netcracker.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers/")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @Operation(summary = "Get all districts where customers live")
    @GetMapping("districts")
    public ResponseEntity<CustomersDistrictsDto> getDistricts() {
        return ResponseEntity.ok(customerService.getCustomersDistrict());
    }
}
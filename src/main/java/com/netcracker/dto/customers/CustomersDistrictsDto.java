package com.netcracker.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
public class CustomersDistrictsDto {
    private List<String> districts;
}
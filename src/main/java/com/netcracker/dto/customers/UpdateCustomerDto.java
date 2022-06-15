package com.netcracker.dto.customers;

import lombok.Data;

@Data
public class UpdateCustomerDto {
    private String surname;
    private String district;
    private Integer discount;
}
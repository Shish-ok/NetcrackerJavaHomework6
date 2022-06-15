package com.netcracker.dto.customers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SurnameAndDiscountDto {
    private String surname;
    private int discount;
}
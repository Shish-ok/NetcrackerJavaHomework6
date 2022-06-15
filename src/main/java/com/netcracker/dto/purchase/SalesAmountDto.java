package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@AllArgsConstructor
public class SalesAmountDto {
    private Timestamp date;
    private String surname;
    private int discount;
    private String name;
    private int count;
}
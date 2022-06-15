package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class SalesAmountDto {
    private Date date;
    private String surname;
    private int discount;
    private String name;
    private int count;
}
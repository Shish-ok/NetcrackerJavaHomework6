package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class BookFromOneDistrictDto {
    private String name;
    private String warehouse;
    private int count;
    private int price;
}
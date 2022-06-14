package com.netcracker.dto.books;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NameAndPriceBookDto {
    private String name;
    private int price;
}
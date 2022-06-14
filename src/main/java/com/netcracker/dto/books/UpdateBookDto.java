package com.netcracker.dto.books;

import lombok.Data;

@Data
public class UpdateBookDto {
    private String name;
    private Integer price;
    private String warehouse;
    private Integer count;
}
package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter @Getter
@AllArgsConstructor
public class ProfitMoreThenNDto {
    private int id;
    private String surname;
    private Date date;
}
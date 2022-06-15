package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@AllArgsConstructor
public class SurnameAndDistrictAndDateDto {
    private String surname;
    private String district;
    private Timestamp date;
}
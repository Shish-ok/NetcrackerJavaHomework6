package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
public class SurnameAndDistrictAndDateDto {
    private String surname;
    private String district;
    private Date date;
}
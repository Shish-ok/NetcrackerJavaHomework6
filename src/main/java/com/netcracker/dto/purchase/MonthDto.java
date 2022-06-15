package com.netcracker.dto.purchase;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter @Getter
@AllArgsConstructor
public class MonthDto {
    private Timestamp date;
}
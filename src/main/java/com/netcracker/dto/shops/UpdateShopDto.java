package com.netcracker.dto.shops;

import lombok.Data;

@Data
public class UpdateShopDto {
    private String name;
    private String location;
    private Integer commission;
}
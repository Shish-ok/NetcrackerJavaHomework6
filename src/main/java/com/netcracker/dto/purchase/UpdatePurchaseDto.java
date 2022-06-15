package com.netcracker.dto.purchase;

import com.netcracker.model.Book;
import com.netcracker.model.Customer;
import com.netcracker.model.Shop;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UpdatePurchaseDto {
    private Timestamp date;

    private Shop shopId;

    private Customer customerId;

    private Book bookId;

    private Integer count;

    private Integer price;
}
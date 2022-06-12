package com.netcracker.model;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @CreatedDate
    @Column(name = "date")
    private Date date;

    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private int shopId;

    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private int customerId;

    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private int bookId;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private int price;
}
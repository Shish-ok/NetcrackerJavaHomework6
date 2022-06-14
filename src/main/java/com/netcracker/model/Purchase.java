package com.netcracker.model;

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

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "shop_id", referencedColumnName = "id")
    private Shop shopId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customerId;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    @Column(name = "count")
    private int count;

    @Column(name = "price")
    private int price;
}
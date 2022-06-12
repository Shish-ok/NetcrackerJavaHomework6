package com.netcracker.model;

import javax.persistence.*;

@Entity
@Table (name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "warehouse")
    private String warehouse;

    @Column(name = "count")
    private int count;
}
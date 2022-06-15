CREATE DATABASE bookshop;

CREATE TABLE customers (
    id serial PRIMARY KEY,
    surname character varying(30) NOT NULL,
    district character varying(100) NOT NULL,
    discount integer CHECK (discount > -1 AND discount < 101)
);

CREATE TABLE shops (
    id serial PRIMARY KEY,
    name character varying(30) NOT NULL,
    location character varying(100) NOT NULL,
    commission integer CHECK (commission > -1 AND commission < 101)
);

CREATE TABLE books (
    id serial PRIMARY KEY,
    name character varying(30) NOT NULL,
    price integer NOT NULL CHECK (count > -1),
    warehouse character varying(100) NOT NULL,
    count integer CHECK (count > -1)
);

CREATE TABLE purchases (
    id serial PRIMARY KEY,
    date TIMESTAMP NOT NULL,
    shop_id integer REFERENCES shops(id),
    customer_id integer REFERENCES customers(id),
    book_id integer REFERENCES books(id),
    count integer NOT NULL CHECK (count > -1),
    price integer NOT NULL
);
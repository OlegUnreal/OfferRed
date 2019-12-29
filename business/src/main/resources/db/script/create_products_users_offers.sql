CREATE TABLE users
(
    id        int PRIMARY KEY,
    name      varchar(40) UNIQUE,
    user_role varchar(10)
);

CREATE TABLE products
(
    id           int PRIMARY KEY,
    name         varchar(40),
    price        int,
    category     varchar(20),
    productOwner int,
    FOREIGN KEY (productOwner) REFERENCES users (id)
);

CREATE TABLE offers
(
    id           int PRIMARY KEY,
    price        int,
    offer_status varchar(20)
);

CREATE TABLE offer_product
(
    offer_id   int,
    product_id int,
    FOREIGN KEY (product_id) REFERENCES products (id),
    FOREIGN KEY (offer_id) REFERENCES offers (id)
);

ALTER TABLE users
    ADD age int;
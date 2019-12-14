package com.epam.oleg.business.entities;

import lombok.Data;

@Data
public class Product {
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    private User productOwner;
}

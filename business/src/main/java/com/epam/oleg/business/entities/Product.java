package com.epam.oleg.business.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private int price;
    @ManyToOne
    @JoinColumn
    private User productOwner;
}

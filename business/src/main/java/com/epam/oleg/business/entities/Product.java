package com.epam.oleg.business.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ProductCategory category;
    private int price;
    @ManyToOne
    @JoinColumn
    private User productOwner;
}

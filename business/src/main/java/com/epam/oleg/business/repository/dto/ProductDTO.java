package com.epam.oleg.business.repository.dto;

import com.epam.oleg.business.entities.ProductCategory;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Data
public class ProductDTO {
    @Id
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    @ManyToOne
    @JoinColumn
    private UserDTO productOwner;
}

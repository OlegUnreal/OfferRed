package com.epam.oleg.business.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private UserRole userRole;
    @OneToMany(mappedBy = "productOwner")
    private List<Product> products;
    @OneToMany(mappedBy = "offerOwner")
    private List<Offer> offers;
}

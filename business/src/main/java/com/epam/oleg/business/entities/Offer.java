package com.epam.oleg.business.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "offers")
@Data
public class Offer {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;
    @ManyToOne
    @JoinColumn
    private User offerOwner;
    @OneToMany
    private List<Product> products;
}

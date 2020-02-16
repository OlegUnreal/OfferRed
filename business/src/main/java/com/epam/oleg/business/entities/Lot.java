package com.epam.oleg.business.entities;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "lots")
public class Lot {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    private int startedPrice;
    private int currentPrice;
    private int finalPrice;

    @Enumerated(value = EnumType.STRING)
    private LotStatus lotStatus;

    @OneToOne
    private User lotOwner;

    @OneToOne
    private Offer offer;
}

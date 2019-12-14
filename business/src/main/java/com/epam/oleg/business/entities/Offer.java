package com.epam.oleg.business.entities;

import lombok.Data;

import java.util.List;

@Data
public class Offer {
    private String id;
    private OfferStatus offerStatus;
    private List<Product> products;
}

package com.epam.oleg.training_project.entities;

import lombok.Data;

import java.util.List;

@Data
public class Offer {
    private String id;
    private OfferStatus offerStatus;
    private List<Product> products;
}

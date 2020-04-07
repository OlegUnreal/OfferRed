package com.epam.oleg.client.dto;

import lombok.Data;

import java.util.List;

@Data
public class OfferDTO {
    private String id;
    private String offerStatus;
    private String ownerId;
    private List<String> productIds;
    private int price;
}

package com.epam.oleg.soapclient.dto;

import lombok.Data;

import java.util.List;

@Data
public class OfferDTO {
    private String offerStatus;
    private String ownerId;
    private List<String> productIds;
    private int price;
}

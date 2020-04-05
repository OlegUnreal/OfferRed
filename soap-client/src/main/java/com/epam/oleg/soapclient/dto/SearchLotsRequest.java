package com.epam.oleg.soapclient.dto;

import lombok.Data;

@Data
public class SearchLotsRequest {
    private int startedPrice;
    private int currentPrice;
    private int finalPrice;
    private String lotStatus;
    private String ownerId;
    private String offerId;
}

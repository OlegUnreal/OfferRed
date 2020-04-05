package com.epam.oleg.soapclient.dto;

import lombok.Data;

@Data
public class SearchOffersRequest {
    private String offerStatus;
    private String ownerId;
    private String productId;
}

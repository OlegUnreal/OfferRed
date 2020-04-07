package com.epam.oleg.client.dto;

import lombok.Data;

@Data
public class SearchOffersRequest {
    private String offerStatus;
    private String ownerId;
    private String productId;
}

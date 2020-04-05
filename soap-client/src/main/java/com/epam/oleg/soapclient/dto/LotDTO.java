package com.epam.oleg.soapclient.dto;

import com.oleg.epam.soapclient.LotStatus;
import lombok.Data;

@Data
public class LotDTO {
    private String id;
    private int startedPrice;
    private int currentPrice;
    private int finalPrice;
    private String lotStatus;
    private String ownerId;
    private String offerId;
}

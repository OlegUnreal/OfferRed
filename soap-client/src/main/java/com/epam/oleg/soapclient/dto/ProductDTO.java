package com.epam.oleg.soapclient.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String name;
    private String category;
    private int price;
    private String ownerId;
}

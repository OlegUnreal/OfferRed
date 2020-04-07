package com.epam.oleg.client.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String category;
    private int price;
    private String ownerId;
}

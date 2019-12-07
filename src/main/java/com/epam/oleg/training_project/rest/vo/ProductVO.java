package com.epam.oleg.training_project.rest.vo;

import lombok.Data;

import java.util.UUID;

@Data
public class ProductVO {
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    private UserVO productOwner;
}

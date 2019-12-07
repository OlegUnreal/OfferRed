package com.epam.oleg.training_project.rest.vo;

import com.epam.oleg.training_project.entities.ProductCategory;
import lombok.Data;

@Data
public class ProductVO {
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    private UserVO productOwner;
}

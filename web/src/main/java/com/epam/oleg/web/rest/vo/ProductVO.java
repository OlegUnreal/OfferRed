package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.ProductCategory;
import lombok.Data;

@Data
public class ProductVO {
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    private UserVO productOwner;
}

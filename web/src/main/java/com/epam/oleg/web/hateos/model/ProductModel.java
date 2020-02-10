package com.epam.oleg.web.hateos.model;

import com.epam.oleg.business.entities.ProductCategory;
import com.epam.oleg.business.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel extends RepresentationModel<ProductModel> {
    private String id;
    private String name;
    private ProductCategory category;
    private int price;
    private User productOwner;
}

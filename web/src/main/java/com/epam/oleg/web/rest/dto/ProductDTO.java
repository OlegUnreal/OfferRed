package com.epam.oleg.web.rest.dto;

import com.epam.oleg.business.entities.ProductCategory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ProductDTO {
    @JsonIgnore
    private String id;

    @NotNull(message = "Name cannot be null")
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Category cannot be null")
    private ProductCategory category;

    @Min(value = 0, message = "Price cannot be less than 0")
    private int price;

    private UserDTO productOwner;
}

package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.OfferStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class OfferDTO {
    @NotNull(message = "Id cannot be null")
    @NotEmpty(message = "Id cannot be empty")
    private String id;

    @NotNull(message = "OfferStatus cannot be null")
    private OfferStatus offerStatus;

    @JsonIgnore
    private List<ProductDTO> products;

    @JsonIgnore
    private UserDTO offerOwner;

    @NotNull(message = "Product ids list cannot be null")
    @NotEmpty(message = "Product ids list cannot be empty")
    private List<@NotEmpty(message = "Product id cannot be empty")
    @NotNull(message = "Product id cannot be null") String> productsIds;
}

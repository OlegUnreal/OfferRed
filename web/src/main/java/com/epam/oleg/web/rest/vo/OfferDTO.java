package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.OfferStatus;
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

    @NotNull(message = "Products cannot be null")
    private List<@NotNull ProductDTO> products;
}

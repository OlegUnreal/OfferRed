package com.epam.oleg.web.rest.dto;

import com.epam.oleg.business.entities.LotStatus;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class LotDTO {
    @NotNull(message = "Lot id cannot be null")
    @NotEmpty(message = "Lot id cannot be empty")
    private String id;

    @Min(value = 0, message = "Started price cannot be less then 0")
    private int startedPrice;

    @Min(value = 0, message = "Current price cannot be less then 0")
    private int currentPrice;

    @Min(value = 0, message = "Final price cannot be less then 0")
    private int finalPrice;

    @NotNull(message = "lotStatus cannot be null")
    private LotStatus lotStatus;

    @NotEmpty(message = "Offer id cannot be empty")
    private String offerId;
}

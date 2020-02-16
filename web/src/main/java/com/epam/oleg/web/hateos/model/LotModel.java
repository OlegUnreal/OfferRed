package com.epam.oleg.web.hateos.model;

import com.epam.oleg.business.entities.LotStatus;
import com.epam.oleg.business.entities.Offer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LotModel extends RepresentationModel<OfferModel> {
    private String id;
    private int startedPrice;
    private int currentPrice;
    private int finalPrice;
    private LotStatus lotStatus;
    private Offer offer;
}

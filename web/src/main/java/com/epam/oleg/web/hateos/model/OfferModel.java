package com.epam.oleg.web.hateos.model;

import com.epam.oleg.business.entities.OfferStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OfferModel extends RepresentationModel<OfferModel> {
    private String id;
    private OfferStatus offerStatus;
    private UserModel offerOwner;
    private List<ProductModel> products;
    private int price;
}

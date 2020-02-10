package com.epam.oleg.web.hateos.model;

import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
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
    private User offerOwner;
    private List<Product> products;
}

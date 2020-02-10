package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.web.hateos.model.OfferModel;
import com.epam.oleg.web.rest.controller.OfferController;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class OfferModelAssembler extends RepresentationModelAssemblerSupport<Offer, OfferModel> {

    public OfferModelAssembler() {
        super(OfferController.class, OfferModel.class);
    }

    @Override
    public OfferModel toModel(Offer entity) {
        return null;
    }
}

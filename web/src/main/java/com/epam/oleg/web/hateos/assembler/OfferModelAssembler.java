package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.web.hateos.model.OfferModel;
import com.epam.oleg.web.rest.controller.OfferController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OfferModelAssembler extends RepresentationModelAssemblerSupport<Offer, OfferModel> {
    private final ProductModelAssembler productModelAssembler;
    private final UserModelAssembler userModelAssembler;

    @Autowired
    public OfferModelAssembler(ProductModelAssembler productModelAssembler, UserModelAssembler userModelAssembler) {
        super(OfferController.class, OfferModel.class);
        this.productModelAssembler = productModelAssembler;
        this.userModelAssembler = userModelAssembler;
    }

    @Override
    public OfferModel toModel(Offer entity) {
        OfferModel offerModel = instantiateModel(entity);
        offerModel.add(linkTo(methodOn(OfferController.class)
                .getOffer(entity.getId()))
                .withSelfRel());

        offerModel.setId(entity.getId());
        offerModel.setOfferOwner(userModelAssembler.toModel(entity.getOfferOwner()));
        offerModel.setOfferStatus(entity.getOfferStatus());
        offerModel.setProducts(entity.getProducts().stream()
                .map(productModelAssembler::toModel)
                .collect(Collectors.toList()));
        offerModel.setPrice(entity.getPrice());
        return offerModel;
    }

    @Override
    public CollectionModel<OfferModel> toCollectionModel(Iterable<? extends Offer> entities) {
        CollectionModel<OfferModel> offerModels = super.toCollectionModel(entities);
        offerModels.add(linkTo(methodOn(OfferController.class).getAll(null, null, null, null))
                .withSelfRel()
                .expand());
        return offerModels;
    }
}

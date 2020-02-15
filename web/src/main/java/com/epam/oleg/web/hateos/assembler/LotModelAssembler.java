package com.epam.oleg.web.hateos.assembler;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.web.hateos.model.LotModel;
import com.epam.oleg.web.rest.controller.LotController;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class LotModelAssembler extends RepresentationModelAssemblerSupport<Lot, LotModel> {

    public LotModelAssembler() {
        super(Lot.class, LotModel.class);
    }

    @Override
    public LotModel toModel(Lot entity) {
        LotModel lotModel = instantiateModel(entity);
        lotModel.add(linkTo(methodOn(LotController.class)
                .getLot(entity.getId()))
                .withSelfRel());
        lotModel.setId(entity.getId());
        lotModel.setCurrentPrice(entity.getCurrentPrice());
        lotModel.setFinalPrice(entity.getFinalPrice());
        lotModel.setStartedPrice(entity.getStartedPrice());
        lotModel.setLotStatus(entity.getLotStatus());
        lotModel.setOffer(entity.getOffer());

        return lotModel;
    }

    @Override
    public CollectionModel<LotModel> toCollectionModel(Iterable<? extends Lot> entities) {
        CollectionModel<LotModel> lotModels = super.toCollectionModel(entities);
        lotModels.add(linkTo(methodOn(LotController.class)
                .getAll(null))
                .withSelfRel());
        return lotModels;
    }
}

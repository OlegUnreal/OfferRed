package com.epam.oleg.business.mapper;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.repository.dto.OfferDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class OfferMapper {

    public static Offer toEntity(OfferDTO offerDTO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
    }

    public static OfferDTO toDto(Offer offer) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(offer, OfferDTO.class);
    }
}

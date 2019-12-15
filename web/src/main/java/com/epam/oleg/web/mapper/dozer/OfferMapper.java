package com.epam.oleg.web.mapper.dozer;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.web.rest.vo.OfferVO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;

public class OfferMapper {

    public static Offer toEntity(OfferVO offerVO) {
        return DozerBeanMapperBuilder.buildDefault()
                .map(offerVO, Offer.class);
    }
}

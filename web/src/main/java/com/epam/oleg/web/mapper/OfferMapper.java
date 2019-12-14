package com.epam.oleg.web.mapper;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.web.rest.vo.OfferVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OfferMapper {
    Offer toEntity(OfferVO offerVO);

    OfferVO toVO(Offer offer);
}

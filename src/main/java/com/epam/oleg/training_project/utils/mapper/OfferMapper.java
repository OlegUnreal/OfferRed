package com.epam.oleg.training_project.utils.mapper;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.rest.vo.OfferVO;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface OfferMapper {
    Offer toEntity(OfferVO offerVO);

    OfferVO toVO(Offer offer);
}

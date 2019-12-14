package com.epam.oleg.web.rest.vo;

import com.epam.oleg.business.entities.OfferStatus;
import lombok.Data;

import java.util.List;

@Data
public class OfferVO {
    private String id;
    private OfferStatus offerStatus;
    private List<ProductVO> productVOS;
}

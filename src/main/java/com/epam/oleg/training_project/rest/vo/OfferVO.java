package com.epam.oleg.training_project.rest.vo;

import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
public class OfferVO {
    private String id;
    private OfferStatus offerStatus;
    private List<ProductVO> productVOS;
}

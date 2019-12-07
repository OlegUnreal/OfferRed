package com.epam.oleg.training_project.rest.vo;

import com.epam.oleg.training_project.entities.OfferStatus;
import lombok.Data;

import java.util.List;

@Data
public class OfferVO {
    private String id;
    private OfferStatus offerStatus;
    private List<ProductVO> productVOS;
}

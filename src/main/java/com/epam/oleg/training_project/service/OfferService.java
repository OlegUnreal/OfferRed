package com.epam.oleg.training_project.service;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.rest.vo.OfferVO;

import java.util.List;

public interface OfferService {
    List<Offer> getAll();

    Offer getById(String id);

    Offer save(OfferVO offer);

    Offer update(OfferVO offer);

    void delete(String id);
}

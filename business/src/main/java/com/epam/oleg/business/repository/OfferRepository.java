package com.epam.oleg.business.repository;

import com.epam.oleg.business.entities.Offer;

import java.util.List;

public interface OfferRepository {
    List<Offer> getAll();

    Offer getById(String id);

    Offer save(Offer offer);

    Offer update(Offer offer);

    void delete(String id);
}

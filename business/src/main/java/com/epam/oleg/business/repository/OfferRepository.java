package com.epam.oleg.training_project.repository;

import com.epam.oleg.training_project.entities.Offer;

import java.util.List;

public interface OfferRepository {
    List<Offer> getAll();

    Offer getById(String id);

    Offer save(Offer offer);

    Offer update(Offer offer);

    void delete(String id);
}

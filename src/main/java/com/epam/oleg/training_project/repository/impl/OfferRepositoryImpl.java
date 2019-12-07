package com.epam.oleg.training_project.repository.impl;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.entities.OfferStatus;
import com.epam.oleg.training_project.repository.OfferRepository;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Repository
public class OfferRepositoryImpl implements OfferRepository {
    @Override
    public List<Offer> getAll() {
        Offer offer = new Offer();
        offer.setId(UUID.randomUUID().toString());
        offer.setOfferStatus(OfferStatus.NEW);
        offer.setProducts(Collections.emptyList());
        return Collections.singletonList(offer);
    }

    @Override
    public Offer getById(String id) {
        return null;
    }
}

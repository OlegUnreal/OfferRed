package com.epam.oleg.business.repository.impl;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.repository.OfferRepository;
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

    @Override
    public Offer save(Offer offer) {
        return null;
    }

    @Override
    public Offer update(Offer offer) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}

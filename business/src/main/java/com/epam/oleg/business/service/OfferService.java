package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Offer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {
    List<Offer> getAll();

    Offer getById(String id);

    Offer save(Offer offer);

    Offer update(Offer offer);

    void delete(String id);
}

package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface OfferService {
    Page<Offer> getAll(Pageable pageable);

    Offer getById(String id);

    Offer save(Offer offer);

    Offer update(Offer offer);

    void buyOffer(String id, User user);

    void delete(String id);
}

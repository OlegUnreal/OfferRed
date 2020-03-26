package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfferService {

    List<Offer> findAll(OfferStatus offerStatus, String offerOwner, String productId);

    Offer getById(String id);

    Offer save(Offer offer);

    Offer update(Offer offer);

    void buyOffer(String id, User user);

    void delete(String id);
}

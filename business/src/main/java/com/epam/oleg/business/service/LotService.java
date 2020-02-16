package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Lot;

import java.util.List;


public interface LotService {
    List<Lot> findAll(Integer startedPrice, Integer currentPrice, Integer finalPrice, String status, String offerId,
                      String ownerId);

    Lot getById(String id);

    Lot save(Lot lot);

    Lot update(Lot lot);

    void delete(String id);
}

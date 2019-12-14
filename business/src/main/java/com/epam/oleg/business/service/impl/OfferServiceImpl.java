package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.repository.OfferRepository;
import com.epam.oleg.business.service.OfferService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    @Override
    public List<Offer> getAll() {
        return offerRepository.getAll();
    }

    @Override
    public Offer getById(String id) {
        return offerRepository.getById(id);
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer update(Offer offer) {
        return offerRepository.update(offer);
    }

    @Override
    public void delete(String id) {
        offerRepository.delete(id);
    }
}

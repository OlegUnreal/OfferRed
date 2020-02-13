package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.OfferRepository;
import com.epam.oleg.business.service.OfferService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OfferServiceImpl implements OfferService {

    private final OfferRepository offerRepository;

    @Override
    public Page<Offer> getAll(Pageable pageable) {
        return offerRepository.findAll(pageable);
    }

    @Override
    public Offer getById(String id) {
        return offerRepository.findById(id).orElseThrow((() -> new NotFoundException("User with id " + id
                + " not found")));
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public Offer update(Offer offer) {
        if (offerRepository.existsById(offer.getId())) {
            return offerRepository.save(offer);
        }
        throw new NotFoundException("Can't update offer with id " + offer.getId() + ". Offer not found");
    }

    @Override
    public void delete(String id) {
        offerRepository.deleteById(id);
    }
}

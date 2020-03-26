package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.entities.LotStatus;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.LotCriteria;
import com.epam.oleg.business.repository.LotRepository;
import com.epam.oleg.business.service.LotService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository repository;
    private final LotCriteria lotCriteria;

    @Override
    public List<Lot> findAll(Integer startedPrice, Integer currentPrice, Integer finalPrice, LotStatus status,
                             String offerId, String ownerId) {
        return lotCriteria.findAll(startedPrice, currentPrice, finalPrice, status, offerId, ownerId);
    }

    @Override
    public Lot getById(String id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("Lot with such id doesn't exist"));
    }

    @Override
    public Lot save(Lot lot) {
        return repository.save(lot);
    }

    @Override
    public Lot update(Lot lot) {
        if (repository.existsById(lot.getId())) {
            return repository.save(lot);
        }
        throw new NotFoundException("Can't update offer with id " + lot.getId() + ". Lot not found");
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

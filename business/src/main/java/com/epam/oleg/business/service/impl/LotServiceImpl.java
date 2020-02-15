package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.exception.NotFoundException;
import com.epam.oleg.business.repository.LotRepository;
import com.epam.oleg.business.service.LotService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LotServiceImpl implements LotService {

    private final LotRepository repository;

    @Override
    public List<Lot> getAll(Pageable pageable) {
        return repository.findAll(pageable).getContent();
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

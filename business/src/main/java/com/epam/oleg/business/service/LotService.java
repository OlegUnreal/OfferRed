package com.epam.oleg.business.service;

import com.epam.oleg.business.entities.Lot;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface LotService {
    List<Lot> getAll(Pageable pageable);

    Lot getById(String id);

    Lot save(Lot lot);

    Lot update(Lot lot);

    void delete(String id);
}

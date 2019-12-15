package com.epam.oleg.business.service.impl;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.mapper.OfferMapper;
import com.epam.oleg.business.repository.OfferRepository;
import com.epam.oleg.business.repository.dto.OfferDTO;
import com.epam.oleg.business.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    @Autowired
    private OfferRepository offerRepository;

    @Override
    public List<Offer> getAll() {
        return offerRepository.findAll().stream()
                .map(OfferMapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Offer getById(String id) {
        Optional<OfferDTO> offerDTO = offerRepository.findById(id);
        return offerDTO.map(OfferMapper::toEntity).orElse(null);
    }

    @Override
    public Offer save(Offer offer) {
        OfferDTO offerDTO = offerRepository.save(OfferMapper.toDto(offer));
        return OfferMapper.toEntity(offerDTO);
    }

    @Override
    public Offer update(Offer offer) {
        if (offerRepository.existsById(offer.getId())) {
            return OfferMapper.toEntity(offerRepository.save(OfferMapper.toDto(offer)));
        }
        //Exception should be thrown
        return null;
    }

    @Override
    public void delete(String id) {
        offerRepository.deleteById(id);
    }
}

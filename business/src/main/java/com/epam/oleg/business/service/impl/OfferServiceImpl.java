package com.epam.oleg.training_project.service.impl;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.repository.OfferRepository;
import com.epam.oleg.training_project.rest.vo.OfferVO;
import com.epam.oleg.training_project.service.OfferService;
import com.epam.oleg.training_project.utils.mapper.OfferMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;
    private OfferMapper offerMapper;

    @Override
    public List<Offer> getAll() {
        return offerRepository.getAll();
    }

    @Override
    public Offer getById(String id) {
        return offerRepository.getById(id);
    }

    @Override
    public Offer save(OfferVO offerVO) {
        Offer offer = offerMapper.toEntity(offerVO);
        return offerRepository.save(offer);
    }

    @Override
    public Offer update(OfferVO offerVO) {
        Offer offer = offerMapper.toEntity(offerVO);
        return offerRepository.update(offer);
    }

    @Override
    public void delete(String id) {
        offerRepository.delete(id);
    }
}

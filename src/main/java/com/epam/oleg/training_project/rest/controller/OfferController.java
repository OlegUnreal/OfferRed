package com.epam.oleg.training_project.rest.controller;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferRepository offerRepository;

    @GetMapping
    public List<Offer> getAll() {
        return offerRepository.getAll();
    }

    @GetMapping("/{id}")
    public Offer getOffer(@PathVariable String id) {
        return offerRepository.getById(id);
    }
}

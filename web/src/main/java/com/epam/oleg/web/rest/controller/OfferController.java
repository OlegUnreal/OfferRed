package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.web.rest.vo.OfferDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<Offer> getAll(@PageableDefault Pageable pageable) {
        return offerService.getAll(pageable);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Offer getOffer(@PathVariable String id) {
        return offerService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Offer createOffer(@Valid @RequestBody OfferDTO offerDTO) {
        Offer offer = DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
        return offerService.save(offer);
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Offer updateOffer(@PathVariable String id, @Valid @RequestBody OfferDTO offerDTO) {
        offerDTO.setId(id);
        Offer offer = DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
        return offerService.update(offer);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteOffer(@PathVariable String id) {
        offerService.delete(id);
    }
}

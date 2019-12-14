package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.web.mapper.OfferMapper;
import com.epam.oleg.web.rest.vo.OfferVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/offers")
public class OfferController {
    @Autowired
    private OfferService offerService;
    @Autowired
    private OfferMapper offerMapper;

    @GetMapping
    public ResponseEntity<List<Offer>> getAll() {
        return ResponseEntity.ok(offerService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Offer> getOffer(@PathVariable String id) {
        return ResponseEntity.ok(offerService.getById(id));
    }

    @PostMapping
    public ResponseEntity<Offer> createOffer(@RequestBody OfferVO offerVO) {
        Offer offer = offerMapper.toEntity(offerVO);
        return ResponseEntity.ok(offerService.save(offer));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable String id, @RequestBody OfferVO offerVO) {
        offerVO.setId(id);
        Offer offer = offerMapper.toEntity(offerVO);
        return ResponseEntity.ok(offerService.update(offer));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteOffer(@PathVariable String id) {
        offerService.delete(id);
    }
}

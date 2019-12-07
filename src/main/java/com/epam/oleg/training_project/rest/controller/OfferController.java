package com.epam.oleg.training_project.rest.controller;

import com.epam.oleg.training_project.entities.Offer;
import com.epam.oleg.training_project.rest.vo.OfferVO;
import com.epam.oleg.training_project.service.OfferService;
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
        return ResponseEntity.ok(offerService.save(offerVO));
    }

    @PostMapping("/{id}")
    public ResponseEntity<Offer> updateOffer(@PathVariable String id, @RequestBody OfferVO offerVO) {
        offerVO.setId(id);
        return ResponseEntity.ok(offerService.update(offerVO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteOffer(@PathVariable String id) {
        offerService.delete(id);
    }
}

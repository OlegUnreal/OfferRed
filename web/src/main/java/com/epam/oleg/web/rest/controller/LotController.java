package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.LotService;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.hateos.assembler.LotModelAssembler;
import com.epam.oleg.web.hateos.model.LotModel;
import com.epam.oleg.web.rest.controller.auth.utils.AuthUtils;
import com.epam.oleg.web.rest.dto.LotDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
public class LotController {

    private final LotService lotService;
    private final LotModelAssembler assembler;
    private final UserService userService;
    private final OfferService offerService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<LotModel> findAll(Integer startedPrice, Integer currentPrice, Integer finalPrice,
                                             String status, String offerId, String ownerId) {
        return assembler.toCollectionModel(
                lotService.findAll(startedPrice, currentPrice, finalPrice, status, offerId, ownerId));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LotModel getLot(@PathVariable String id) {
        return assembler.toModel(lotService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LotModel createLot(@Valid @RequestBody LotDTO lotDTO) {
        User user = userService.getByEmail(AuthUtils.getCurrentAuth().getName());
        Lot lot = DozerBeanMapperBuilder.buildDefault().map(lotDTO, Lot.class);
        lot.setLotOwner(user);
        lot.setOffer(offerService.getById(lotDTO.getId()));
        return assembler.toModel(lotService.save(lot));
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission(#id, 'OFFER','UPDATE')")
    public LotModel updateLot(@PathVariable String id, @Valid @RequestBody LotDTO lotDTO) {
        lotDTO.setId(id);
        Lot lot = DozerBeanMapperBuilder.buildDefault().map(lotDTO, Lot.class);
        lot.setOffer(offerService.getById(lotDTO.getId()));

        return assembler.toModel(lotService.update(lot));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasPermission(#id, 'OFFER','DELETE')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Lot deleted successfully")
    public void deleteLot(@PathVariable String id) {
        lotService.delete(id);
    }
}

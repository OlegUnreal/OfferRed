package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.service.LotService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.hateos.assembler.LotModelAssembler;
import com.epam.oleg.web.hateos.model.LotModel;
import com.epam.oleg.web.rest.dto.LotDTO;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<LotModel> getAll(@PageableDefault Pageable pageable) {
        return assembler.toCollectionModel(lotService.getAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LotModel getLot(@PathVariable String id) {
        return assembler.toModel(lotService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public LotModel createLot(@Valid @RequestBody LotDTO lotDTO) {
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission(#id, 'OFFER','UPDATE')")
    public LotModel updateLot(@PathVariable String id, @Valid @RequestBody LotDTO lotDTO) {
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasPermission(#id, 'OFFER','DELETE')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Lot deleted successfully")
    public void deleteLot(@PathVariable String id) {
        lotService.delete(id);
    }
}

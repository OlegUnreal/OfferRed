package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.repository.OfferCriteria;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.hateos.assembler.OfferModelAssembler;
import com.epam.oleg.web.hateos.model.OfferModel;
import com.epam.oleg.web.rest.controller.auth.utils.AuthUtils;
import com.epam.oleg.web.rest.dto.OfferDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.CollectionModel;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/offers")
@AllArgsConstructor
public class OfferController {

    private OfferService offerService;
    private ProductService productService;
    private UserService userService;
    private OfferCriteria offerCriteria;
    private OfferModelAssembler assembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<OfferModel> getAll(@PageableDefault Pageable pageable,
                                              @RequestParam(required = false) String offerStatus,
                                              @RequestParam(required = false) String ownerName,
                                              @RequestParam(required = false) String productName) {
        return assembler.toCollectionModel(offerCriteria.findAll(offerStatus, ownerName, productName));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OfferModel getOffer(@PathVariable String id) {
        return assembler.toModel(offerService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public OfferModel createOffer(@Valid @RequestBody OfferDTO offerDTO) {
        User user = userService.getByEmail(AuthUtils.getCurrentAuth().getName());

        List<Product> products = new ArrayList<>();
        offerDTO.getProductsIds().forEach(id -> products.add(productService.getById(id)));

        Offer offer = DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
        offer.setOfferOwner(user);
        offer.setProducts(products);
        return assembler.toModel(offerService.save(offer));
    }

    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OfferModel updateOffer(@PathVariable String id, @Valid @RequestBody OfferDTO offerDTO) {
        offerDTO.setId(id);
        Offer offer = DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
        return assembler.toModel(offerService.update(offer));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteOffer(@PathVariable String id) {
        offerService.delete(id);
    }
}

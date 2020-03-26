package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.entities.Product;
import com.epam.oleg.business.entities.User;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.business.service.UserService;
import com.epam.oleg.web.hateos.assembler.OfferModelAssembler;
import com.epam.oleg.web.hateos.model.OfferModel;
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

import static com.epam.oleg.web.rest.controller.auth.utils.AuthUtils.getCurrentAuth;

@RestController
@RequestMapping("/offers")
@AllArgsConstructor
public class OfferController {

    private final OfferService offerService;
    private final ProductService productService;
    private final UserService userService;
    private final OfferModelAssembler assembler;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CollectionModel<OfferModel> getAll(@PageableDefault Pageable pageable,
                                              @RequestParam(required = false) OfferStatus offerStatus,
                                              @RequestParam(required = false) String ownerName,
                                              @RequestParam(required = false) String productName) {
        return assembler.toCollectionModel(offerService.findAll(offerStatus, ownerName, productName));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public OfferModel getOffer(@PathVariable String id) {
        return assembler.toModel(offerService.getById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OfferModel createOffer(@Valid @RequestBody OfferDTO offerDTO) {
        User user = userService.getByEmail(getCurrentAuth().getName());

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
    @PreAuthorize("hasPermission(#id, 'OFFER','UPDATE')")
    public OfferModel updateOffer(@PathVariable String id, @Valid @RequestBody OfferDTO offerDTO) {
        offerDTO.setId(id);
        Offer offer = DozerBeanMapperBuilder.buildDefault()
                .map(offerDTO, Offer.class);
        return assembler.toModel(offerService.update(offer));
    }

    @PostMapping("/{id}/buy")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasPermission(#id, 'OFFER', 'BUY')")
    public void buyOffer(@PathVariable String id) {
        User user = userService.getByEmail(getCurrentAuth().getName());
        offerService.buyOffer(id, user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasPermission(#id, 'OFFER','DELETE')")
    @ResponseStatus(code = HttpStatus.OK, reason = "Offer deleted successfully")
    public void deleteOffer(@PathVariable String id) {
        offerService.delete(id);
    }
}

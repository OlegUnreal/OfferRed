package com.epam.oleg.web.rest.controller;

import com.epam.oleg.business.entities.Gender;
import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.UserRole;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.web.rest.vo.OfferDTO;
import com.epam.oleg.web.rest.vo.ProductDTO;
import com.epam.oleg.web.rest.vo.UserDTO;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
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
        //Product and User should be taken from repo
        UserDTO userDTO = new UserDTO();
        userDTO.setId("1");
        userDTO.setName("Oleg");
        userDTO.setUserRole(UserRole.ADMIN);
        userDTO.setCity("Lviv");
        userDTO.setGender(Gender.MALE);
        userDTO.setAge(22);
        offerDTO.setOfferOwner(userDTO);

        List<ProductDTO> products = new ArrayList<>();
        offerDTO.getProductsIds().forEach(id -> products.add(DozerBeanMapperBuilder.buildDefault()
                .map(productService.getById(id), ProductDTO.class)));
        offerDTO.setProducts(products);

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

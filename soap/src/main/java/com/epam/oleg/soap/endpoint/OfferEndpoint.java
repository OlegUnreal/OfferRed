package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.entities.Offer;
import com.epam.oleg.business.entities.OfferStatus;
import com.epam.oleg.business.service.OfferService;
import com.epam.oleg.business.service.ProductService;
import com.epam.oleg.business.service.UserService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import io.spring.guides.gs_producing_web_service.*;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;

@Endpoint
@AllArgsConstructor
public class OfferEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final OfferService offerService;
    private final UserService userService;
    private final ProductService productService;
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOfferRequest")
    public GetOfferResponse getOfferById(@RequestPayload GetOfferRequest req) {
        GetOfferResponse response = new GetOfferResponse();
        final Offer offer = offerService.getById(req.getId());
        response.setOffer(mapper.map(offer, io.spring.guides.gs_producing_web_service.Offer.class));
        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getOfferRequest")
    public GetOffersResponse getOffers(@RequestPayload GetOffersRequest req) {
        GetOffersResponse response = new GetOffersResponse();
        response.getOfferList().addAll(offerService.findAll(OfferStatus.valueOf(req.getOfferStatus().value()),
                req.getOwnerId(),
                req.getProductId())
                .stream()
                .map(e -> mapper.map(e, io.spring.guides.gs_producing_web_service.Offer.class))
                .collect(Collectors.toList()));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "createOfferRequest")
    public GetOfferResponse createOffer(@RequestPayload CreateOfferRequest req) {
        GetOfferResponse response = new GetOfferResponse();
        Offer offer = new Offer();
        offer.setOfferOwner(userService.getById(req.getOwnerId()));
        offer.setOfferStatus(OfferStatus.valueOf(req.getOfferStatus().value()));
        offer.setProducts(req.getProductIds()
                .stream().map(productService::getById)
                .collect(Collectors.toList()));
        offer.setPrice(req.getPrice());

        final Offer saved = offerService.save(offer);
        response.setOffer(mapper.map(saved, io.spring.guides.gs_producing_web_service.Offer.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateOfferRequest")
    public GetOfferResponse updateOffer(@RequestPayload UpdateOfferRequest req) {
        GetOfferResponse response = new GetOfferResponse();
        Offer offer = new Offer();
        offer.setId(req.getId());
        offer.setOfferOwner(userService.getById(req.getOwnerId()));
        offer.setOfferStatus(OfferStatus.valueOf(req.getOfferStatus().value()));
        offer.setProducts(req.getProductIds()
                .stream().map(productService::getById)
                .collect(Collectors.toList()));
        offer.setPrice(req.getPrice());

        final Offer saved = offerService.save(offer);
        response.setOffer(mapper.map(saved, io.spring.guides.gs_producing_web_service.Offer.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteOfferRequest")
    public void deleteOffer(@RequestPayload DeleteOfferRequest req) {
        offerService.delete(req.getId());
    }
}

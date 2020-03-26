package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.service.LotService;
import com.epam.oleg.business.service.OfferService;
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
public class LotEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    private final LotService lotService;
    private final UserService userService;
    private final OfferService offerService;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLotRequest")
    public GetLotResponse getLotById(@RequestPayload GetLotRequest req) {
        GetLotResponse response = new GetLotResponse();
        final Lot lot = lotService.getById(req.getId());
        response.setLot(mapper.map(lot, io.spring.guides.gs_producing_web_service.Lot.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLotsRequest")
    public GetLotsResponse getLots(@RequestPayload GetLotsRequest req) {
        GetLotsResponse response = new GetLotsResponse();
        response.getLot().addAll(lotService.findAll(req.getStartedPrice(),
                req.getCurrentPrice(),
                req.getFinalPrice(),
                com.epam.oleg.business.entities.LotStatus.valueOf(req.getLotStatus().value()),
                req.getOfferId(),
                req.getOwnerId())
                .stream()
                .map(e -> mapper.map(e, io.spring.guides.gs_producing_web_service.Lot.class))
                .collect(Collectors.toList()));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateLotRequest")
    public GetLotResponse updateLot(@RequestPayload UpdateLotRequest req) {
        GetLotResponse response = new GetLotResponse();
        Lot lot = new Lot();
        lot.setId(req.getId());
        lot.setStartedPrice(req.getStartedPrice());
        lot.setCurrentPrice(req.getCurrentPrice());
        lot.setFinalPrice(req.getFinalPrice());
        lot.setLotOwner(userService.getById(req.getOwnerId()));
        lot.setOffer(offerService.getById(req.getOfferId()));

        final Lot update = lotService.update(lot);
        response.setLot(mapper.map(update, io.spring.guides.gs_producing_web_service.Lot.class));

        return response;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteLotRequest")
    public void deleteLot(@RequestPayload DeleteLotRequest req) {
        lotService.delete(req.getId());
    }
}

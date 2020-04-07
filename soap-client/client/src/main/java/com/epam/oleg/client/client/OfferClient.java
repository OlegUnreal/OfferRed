package com.epam.oleg.client.client;

import com.epam.oleg.client.dto.OfferDTO;
import com.epam.oleg.client.dto.SearchOffersRequest;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

public class OfferClient extends WebServiceGatewaySupport {

    public GetOfferResponse getOfferById(String id) {
        GetOfferRequest req = new GetOfferRequest();
        req.setId(id);
        return (GetOfferResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public GetOffersResponse getOffers(SearchOffersRequest req) {
        GetOffersRequest getOffersRequest = new GetOffersRequest();
        getOffersRequest.setOfferStatus(OfferStatus.fromValue(req.getOfferStatus()));
        getOffersRequest.setOwnerId(req.getOwnerId());
        getOffersRequest.setProductId(req.getProductId());

        return (GetOffersResponse) getWebServiceTemplate().marshalSendAndReceive(getOffersRequest);
    }

    public GetOfferResponse createOffer(OfferDTO req) {
        CreateOfferRequest createOfferRequest = new CreateOfferRequest();
        createOfferRequest.setOfferStatus(OfferStatus.fromValue(req.getOfferStatus()));
        createOfferRequest.setOwnerId(req.getOwnerId());
        createOfferRequest.setPrice(req.getPrice());
        createOfferRequest.getProductIds().addAll(req.getProductIds());

        return (GetOfferResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public GetOfferResponse updateOffer(OfferDTO req) {
        UpdateOfferRequest updateOfferRequest = new UpdateOfferRequest();
        updateOfferRequest.setId(req.getId());
        updateOfferRequest.setOfferStatus(OfferStatus.fromValue(req.getOfferStatus()));
        updateOfferRequest.setOwnerId(req.getOwnerId());
        updateOfferRequest.setPrice(req.getPrice());
        updateOfferRequest.getProductIds().addAll(req.getProductIds());

        return (GetOfferResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public void deleteOffer(String id) {
        DeleteOfferRequest req = new DeleteOfferRequest();
        req.setId(id);
        getWebServiceTemplate().marshalSendAndReceive(req);
    }
}

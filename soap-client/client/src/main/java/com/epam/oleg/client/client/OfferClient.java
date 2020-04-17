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
        getOffersRequest.setOwnerId(req.getOwnerId());
        getOffersRequest.setProductId(req.getProductId());
        final String offerStatus = req.getOfferStatus();
        getOffersRequest.setOfferStatus(offerStatus == null ? null : OfferStatus.fromValue(offerStatus));
        return (GetOffersResponse) getWebServiceTemplate().marshalSendAndReceive(getOffersRequest);
    }

    public GetOfferResponse createOffer(OfferDTO req) {
        CreateOfferRequest createOfferRequest = new CreateOfferRequest();
        final String offerStatus = req.getOfferStatus();
        createOfferRequest.setOfferStatus(offerStatus == null ? null : OfferStatus.fromValue(offerStatus));
        createOfferRequest.setOwnerId(req.getOwnerId());
        createOfferRequest.setPrice(req.getPrice());
        createOfferRequest.getProductIds().addAll(req.getProductIds());

        return (GetOfferResponse) getWebServiceTemplate().marshalSendAndReceive(createOfferRequest);
    }

    public GetOfferResponse updateOffer(OfferDTO req) {
        UpdateOfferRequest updateOfferRequest = new UpdateOfferRequest();
        updateOfferRequest.setId(req.getId());
        final String offerStatus = req.getOfferStatus();
        updateOfferRequest.setOfferStatus(offerStatus == null ? null : OfferStatus.fromValue(offerStatus));
        updateOfferRequest.setOwnerId(req.getOwnerId());
        updateOfferRequest.setPrice(req.getPrice());
        updateOfferRequest.getProductIds().addAll(req.getProductIds());

        return (GetOfferResponse) getWebServiceTemplate().marshalSendAndReceive(updateOfferRequest);
    }

    public void deleteOffer(String id) {
        DeleteOfferRequest req = new DeleteOfferRequest();
        req.setId(id);
        getWebServiceTemplate().marshalSendAndReceive(req);
    }
}

package com.epam.oleg.soapclient.client;

import com.epam.oleg.soapclient.dto.LotDTO;
import com.epam.oleg.soapclient.dto.SearchLotsRequest;
import com.oleg.epam.soapclient.*;
import org.opensaml.xmlsec.signature.G;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.stream.Collectors;

public class LotClient extends WebServiceGatewaySupport {

    public GetLotResponse getLotById(String id) {
        GetLotRequest req = new GetLotRequest();
        req.setId(id);

        return (GetLotResponse) getWebServiceTemplate().marshalSendAndReceive(req);
    }

    public GetLotsResponse getLots(SearchLotsRequest req) {
        GetLotsRequest getLotsRequest = new GetLotsRequest();
        getLotsRequest.setCurrentPrice(req.getCurrentPrice());
        getLotsRequest.setFinalPrice(req.getFinalPrice());
        getLotsRequest.setLotStatus(LotStatus.fromValue(req.getLotStatus()));
        getLotsRequest.setOfferId(req.getOfferId());
        getLotsRequest.setOwnerId(req.getOwnerId());
        getLotsRequest.setStartedPrice(req.getStartedPrice());

        return (GetLotsResponse) getWebServiceTemplate().marshalSendAndReceive(getLotsRequest);
    }

    public GetLotResponse updateLot(LotDTO req) {
        UpdateLotRequest updateLotRequest = new UpdateLotRequest();
        updateLotRequest.setId(req.getId());
        updateLotRequest.setCurrentPrice(req.getCurrentPrice());
        updateLotRequest.setFinalPrice(req.getFinalPrice());
        updateLotRequest.setLotStatus(LotStatus.fromValue(req.getLotStatus()));
        updateLotRequest.setOfferId(req.getOfferId());
        updateLotRequest.setOwnerId(req.getOwnerId());
        updateLotRequest.setStartedPrice(req.getStartedPrice());

        return (GetLotResponse) getWebServiceTemplate().marshalSendAndReceive(updateLotRequest);
    }

    public void deleteLot(String id) {
        DeleteLotRequest req = new DeleteLotRequest();
        req.setId(id);

        getWebServiceTemplate().marshalSendAndReceive(req);
    }
}

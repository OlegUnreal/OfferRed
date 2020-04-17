package com.epam.oleg.client.client;

import com.epam.oleg.client.dto.LotDTO;
import com.epam.oleg.client.dto.SearchLotsRequest;
import io.spring.guides.gs_producing_web_service.*;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

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
        final String lotStatus = req.getLotStatus();
        getLotsRequest.setLotStatus(lotStatus == null ? null : LotStatus.fromValue(lotStatus));
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
        final String lotStatus = req.getLotStatus();
        updateLotRequest.setLotStatus(lotStatus == null ? null : LotStatus.fromValue(lotStatus));
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

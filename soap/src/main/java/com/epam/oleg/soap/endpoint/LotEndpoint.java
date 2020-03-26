package com.epam.oleg.soap.endpoint;

import com.epam.oleg.business.entities.Lot;
import com.epam.oleg.business.service.LotService;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import io.spring.guides.gs_producing_web_service.GetLotRequest;
import io.spring.guides.gs_producing_web_service.GetLotResponse;
import io.spring.guides.gs_producing_web_service.GetLotsRequest;
import io.spring.guides.gs_producing_web_service.GetLotsResponse;
import lombok.AllArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@AllArgsConstructor
public class LotEndpoint {

    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private final LotService lotService;

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLotRequest")
    public GetLotResponse getUserById(@RequestPayload GetLotRequest req) {
        GetLotResponse response = new GetLotResponse();
        final Lot lot = lotService.getById(req.getId());
        response.setLot(DozerBeanMapperBuilder.buildDefault().map(lot, io.spring.guides.gs_producing_web_service.Lot.class));

        return response;
    }

//    @ResponsePayload
//    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLotsRequest")
//    public GetLotsResponse getUsers(@RequestPayload GetLotsRequest req) {
//        GetLotsResponse response = new GetLotsResponse();
//        return response;
//    }
}

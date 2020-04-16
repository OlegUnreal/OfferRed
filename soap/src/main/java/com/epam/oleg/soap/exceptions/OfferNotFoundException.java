package com.epam.oleg.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
		customFaultCode = "{" + OfferNotFoundException.NAMESPACE_URI + "}OFFER_NOT_FOUND",
		faultStringOrReason = "Offer does not exist")
public class OfferNotFoundException extends RuntimeException {
	public static final String NAMESPACE_URI = "http://localhost/exception";

	public OfferNotFoundException() {
		super();
	}

    public OfferNotFoundException(String message) {
        super(message);
    }
}

package com.epam.oleg.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
		customFaultCode = "{" + LotNotFoundException.NAMESPACE_URI + "}Lot_NOT_FOUND",
		faultStringOrReason = "Lot does not exist")
public class LotNotFoundException extends RuntimeException {
	public static final String NAMESPACE_URI = "http://localhost/exception";

	public LotNotFoundException() {
		super();
	}

    public LotNotFoundException(String message) {
        super(message);
    }
}

package com.epam.oleg.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
		customFaultCode = "{" + ProductNotFoundException.NAMESPACE_URI + "}PRODUCT_NOT_FOUND",
		faultStringOrReason = "Product does not exist")
public class ProductNotFoundException extends RuntimeException {
	public static final String NAMESPACE_URI = "http://localhost/exception";

	public ProductNotFoundException() {
		super();
	}

    public ProductNotFoundException(String message) {
        super(message);
    }
}

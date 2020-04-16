package com.epam.oleg.soap.exceptions;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM,
		customFaultCode = "{" + UserNotFoundException.NAMESPACE_URI + "} USER_NOT_FOUND",
		faultStringOrReason = "User does not exist")
public class UserNotFoundException extends RuntimeException {
	public static final String NAMESPACE_URI = "http://localhost/exception";

	public UserNotFoundException() {
		super();
	}
	
    public UserNotFoundException(String message) {
        super(message);
    }
}

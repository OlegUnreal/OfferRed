package com.epam.oleg.soap.exceptions;

public class ServiceFaultException extends RuntimeException {

	private int serviceStatus;

	public ServiceFaultException(String message, int serviceStatus) {
		super(message);
		this.serviceStatus = serviceStatus;
	}

	public ServiceFaultException(String message, Throwable e, int serviceStatus) {
		super(message, e);
		this.serviceStatus = serviceStatus;
	}

	public int getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(int serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

}

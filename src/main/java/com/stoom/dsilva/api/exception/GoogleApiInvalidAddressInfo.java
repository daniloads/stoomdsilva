package com.stoom.dsilva.api.exception;

public class GoogleApiInvalidAddressInfo extends IllegalArgumentException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GoogleApiInvalidAddressInfo() {
		super("Invalid address information to retrieve latitude and longitude from google");
	}
}

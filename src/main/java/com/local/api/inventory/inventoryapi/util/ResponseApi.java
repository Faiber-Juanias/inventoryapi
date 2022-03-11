package com.local.api.inventory.inventoryapi.util;

public class ResponseApi {

	private Object response;
	private ErrorApi error;
	
	public Object getResponse() {
		return response;
	}
	public void setResponse(Object response) {
		this.response = response;
	}
	public ErrorApi getError() {
		return error;
	}
	public void setError(ErrorApi error) {
		this.error = error;
	}
	
}

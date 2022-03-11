package com.local.api.inventory.inventoryapi.util;

public class ErrorApi {
	
	private int code;
	private String message;
	private String messageException;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessageException() {
		return messageException;
	}
	public void setMessageException(String messageException) {
		this.messageException = messageException;
	}
	
}

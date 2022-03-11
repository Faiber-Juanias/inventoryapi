package com.local.api.inventory.inventoryapi.error;

import org.springframework.http.HttpStatus;

import com.local.api.inventory.inventoryapi.util.ErrorApi;
import com.local.api.inventory.inventoryapi.util.ResponseApi;

public class ManageOutputException {

	private static ResponseApi responseApi;
	private static ErrorApi errorApi;
	
	public static ResponseApi manageException(HttpStatus codeStatus, Object objectResponse, String errorMessage, String errorMessageException, Integer id) {
		errorApi = new ErrorApi();
		responseApi = new ResponseApi();
		
		if (codeStatus == HttpStatus.OK) {
			errorApi.setCode(codeStatus.value());
			errorApi.setMessage(errorMessage);
			errorApi.setMessageException(errorMessageException);
			try {
				responseApi.setResponse(((String)objectResponse).replace("{}", String.valueOf(id)));								
			} catch (Exception e) {
				responseApi.setResponse(objectResponse);
			}
			responseApi.setError(errorApi);
		} else {
			errorApi.setCode(codeStatus.value());
			errorApi.setMessage(errorMessage.replace("{}", String.valueOf(id)));
			errorApi.setMessageException(errorMessageException);
			
			responseApi.setResponse(null);
			responseApi.setError(errorApi);
		}
		return responseApi;
	}
	
}

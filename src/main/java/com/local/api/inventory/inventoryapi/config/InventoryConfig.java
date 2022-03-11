package com.local.api.inventory.inventoryapi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:inventory.properties")
public class InventoryConfig {
	
	@Value("${inventoryapi.exception.deletebyid}")
	private String messageExceptionDeleteById;
	@Value("${inventoryapi.deletebyid}")
	private String messageDeleteById;
	@Value("${inventoryapi.exception.update-required-id}")
	private String messageExceptionUpdateRequiredId;
	@Value("${inventoryapi.update-required-id}")
	private String messageUpdateRequiredId;
	@Value("${inventoryapi.exception.save}")
	private String messageSave;
	@Value("${inventoryapi.exception.get-filter}")
	private String messageExceptionFilters;
	@Value("${inventoryapi.exception.value-fecha}")
	private String messageExceptionValueFecha;
	@Value("${inventoryapi.exception.product-not-exist}")
	private String messageExceptionProductNotExist;
	@Value("${inventoryapi.product-not-exist}")
	private String messageProductNotExist;
	
	public String getMessageExceptionDeleteById() {
		return messageExceptionDeleteById;
	}
	public String getMessageDeleteById() {
		return messageDeleteById;
	}
	public String getMessageExceptionUpdateRequiredId() {
		return messageExceptionUpdateRequiredId;
	}
	public String getMessageUpdateRequiredId() {
		return messageUpdateRequiredId;
	}
	public String getMessageSave() {
		return messageSave;
	}
	public String getMessageExceptionFilters() {
		return messageExceptionFilters;
	}
	public String getMessageExceptionValueFecha() {
		return messageExceptionValueFecha;
	}
	public String getMessageExceptionProductNotExist() {
		return messageExceptionProductNotExist;
	}
	public String getMessageProductNotExist() {
		return messageProductNotExist;
	}
	
}

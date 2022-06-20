
package com.edu.OnlineGroceryDelivery.Exception;



public class ResourceNotFoundException extends RuntimeException {
	
	private String resourceName;
	private String fieldName;
	private long id;
	public String getResourceName() {
		return resourceName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public long getId() {
		return id;
	}
	public ResourceNotFoundException(String resourceName, String fieldName, long id) {
		super(String.format("%s not found with %s : %s" , resourceName, fieldName, id));

		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.id = id;
	}
	
	
	
	
	}
	
	




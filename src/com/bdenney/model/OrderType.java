package com.bdenney.model;

/**
 * Defines the order types available. 
 * @author Brandon
 */
public enum OrderType {
	ASCENDING("asc"),
	DESCENDING("desc");
	
	public String value;
	
	OrderType(String val) {
		value = val;
	}
}

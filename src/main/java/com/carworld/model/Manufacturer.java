package com.carworld.model;

/**
 * @author: mmathew@manh.com
 */

public class Manufacturer {
	
	private Long manufacturerId;
	private String name = "Not avialble";
	private String address = "Not avialble";
	private Long contactNumber;
	
	
	public Long getManufacturerId() {
		return manufacturerId;
	}
	public void setManufacturerId(Long manufacturerId) {
		this.manufacturerId = manufacturerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}
	

}

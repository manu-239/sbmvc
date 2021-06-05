package com.carworld.service;

import java.util.List;

import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

public interface ManufacturerService {
	
	void addManufacturer(Manufacturer manufacturer) throws Exception;
	List<Manufacturer> getAllManufacturer() throws Exception;
	Manufacturer getManufacturer(Long manufacturerId) throws Exception;
	void deleteManufacturer(Long manufacturerId) throws Exception; 
	
}

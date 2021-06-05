package com.carworld.dao;

import java.sql.SQLException;
import java.util.List;

import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

public interface ManufacturerRepository {
	void addManufacturer(Manufacturer manufacturer) throws SQLException;
	List<Manufacturer> getAllManufacturer() throws SQLException;
	Manufacturer getManufacturer(Long manufacturerId) throws SQLException;
	void deleteManufacturer(Long manufacturerId) throws SQLException; 
}

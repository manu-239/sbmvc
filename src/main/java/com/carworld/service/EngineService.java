package com.carworld.service;

import java.util.List;

import com.carworld.model.Engine;
import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

public interface EngineService {
	
	void addEngine(Engine engine) throws Exception;
	List<Engine> getAllEngine() throws Exception;
	Engine getEngine(Long engineId) throws Exception;
	void deleteEngine(Long engineId) throws Exception; 
	List<Manufacturer> getAllManufactures() throws Exception;

}

package com.carworld.dao;

import java.sql.SQLException;
import java.util.List;

import com.carworld.model.Engine;

/**
 * @author: mmathew@manh.com
 */

public interface EngineRepository {

	void addEngine(Engine engine) throws SQLException;
	List<Engine> getAllEngine() throws SQLException;
	Engine getEngine(Long engineId) throws SQLException;
	void deleteEngine(Long engineId) throws SQLException; 
}

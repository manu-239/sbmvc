package com.carworld.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.carworld.model.Engine;

/**
 * @author: mmathew@manh.com
 */

@Repository
public class JdbcEngineRepository implements EngineRepository{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	
	
	@Override
	public void addEngine(Engine engine) throws SQLException {
		String query="insert into engine(name,enginetype,displacement,manufacturerId) values(?,?,?,?) ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, engine.getEngineName());
		preparedStatement.setString(2, engine.getEngineType());
		preparedStatement.setInt(3, engine.getDisplacement());
		preparedStatement.setLong(4, engine.getEngineManufacturer().getManufacturerId());
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.getGeneratedKeys();
		if(rs.next()){
			System.out.println("engineId ="+rs.getLong(1));
		}
		connection.close();
		System.out.println("Engine saved");
	}

	@Override
	public List<Engine> getAllEngine() throws SQLException {
		String query="select * from engine ";
		Connection connection=dataSource.getConnection();
		ResultSet rs=connection.prepareStatement(query).executeQuery();
		List<Engine> engines = new ArrayList<>();
		while(rs.next()){ 
			Engine engine= new Engine();
			engine.setEngineId(rs.getLong("engineId"));
			engine.setEngineName(rs.getString("name"));
			engine.setEngineType(rs.getString("enginetype"));
			engine.setDisplacement(rs.getInt("displacement"));
			engine.setEngineManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
			engines.add(engine);
		}
		connection.close();
		return engines;
	}

	@Override
	public Engine getEngine(Long engineId) throws SQLException {
		String query="select * from engine where engineId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, engineId);
		ResultSet rs=preparedStatement.executeQuery();
		Engine engine=null;
		if(rs.next()){ 
			engine = new Engine();
			engine.setEngineId(rs.getLong("engineId"));
			engine.setEngineName(rs.getString("name"));
			engine.setEngineType(rs.getString("enginetype"));
			engine.setDisplacement(rs.getInt("displacement"));
			engine.setEngineManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
		}
		connection.close();
		return engine;
	}

	@Override
	public void deleteEngine(Long engineId) throws SQLException {
		String query="delete from engine where engineId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, engineId);
		preparedStatement.executeUpdate();
		System.out.println("Engine Deleted");
		connection.close();
	}


	
}

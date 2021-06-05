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

import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

@Repository
public class JdbcManufacturerRepository implements ManufacturerRepository {

	@Autowired
	private DataSource dataSourceCustom;
	
	

	@Override
	public void addManufacturer(Manufacturer manufacturer) throws SQLException {
		String query="insert into manufacturer(name,address,contactNumber) values(?,?,?) ";
		Connection connection=dataSourceCustom.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, manufacturer.getName());
		preparedStatement.setString(2, manufacturer.getAddress());
		preparedStatement.setLong(3, manufacturer.getContactNumber());
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.getGeneratedKeys();
		if(rs.next()){
			System.out.println("manufacturerId ="+rs.getLong(1));
		}
		connection.close();
		System.out.println("Manufacturer saved");
	}

	@Override
	public List<Manufacturer> getAllManufacturer() throws SQLException {
		String query="select * from manufacturer ";
		Connection connection=dataSourceCustom.getConnection();
		ResultSet rs=connection.prepareStatement(query).executeQuery();
		List<Manufacturer> manufactures = new ArrayList<>();
		while(rs.next()){ 
			Manufacturer manufacturer= new Manufacturer();
			manufacturer.setManufacturerId(rs.getLong("manufacturerId"));
			manufacturer.setName(rs.getString("name"));
			manufacturer.setAddress(rs.getString("address"));
			manufacturer.setContactNumber(rs.getLong("contactNumber"));
			manufactures.add(manufacturer);
		}
		connection.close();
		return manufactures;
	}

	@Override
	public Manufacturer getManufacturer(Long manufacturerId) throws SQLException {
		String query="select * from manufacturer where manufacturerId =? ";
		Connection connection=dataSourceCustom.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, manufacturerId);
		ResultSet rs=preparedStatement.executeQuery();
		Manufacturer manufacturer=null;
		if(rs.next()){ 
			manufacturer = new Manufacturer();
			manufacturer.setManufacturerId(rs.getLong("manufacturerId"));
			manufacturer.setName(rs.getString("name"));
			manufacturer.setAddress(rs.getString("address"));
			manufacturer.setContactNumber(rs.getLong("contactNumber"));
		}
		connection.close();
		return manufacturer;
	}

	@Override
	public void deleteManufacturer(Long manufacturerId) throws SQLException {
		String query="delete from manufacturer where manufacturerId =? ";
		Connection connection=dataSourceCustom.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, manufacturerId);
		preparedStatement.executeUpdate();
		System.out.println("Manufacturer Deleted");
		connection.close();
	}
	
	
}

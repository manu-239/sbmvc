package com.carworld.dao;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
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

import com.carworld.model.Car;

/**
 * @author: mmathew@manh.com
 */

@Repository
public class JdbcCarRepository implements CarRepository{

	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private EngineRepository engineRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	

	
	
	@Override
	public void addCar(Car car) throws SQLException {
		String query="insert into car (model,color,price,engineId,manufacturerId) values(?,?,?,?,?) ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
		preparedStatement.setString(1, car.getModel());
		preparedStatement.setString(2, car.getColor());
		preparedStatement.setDouble(3, car.getPrice());
		preparedStatement.setLong(4, car.getEngine().getEngineId());
		preparedStatement.setLong(5, car.getManufacturer().getManufacturerId());
		preparedStatement.executeUpdate();
		ResultSet rs=preparedStatement.getGeneratedKeys();
		if(rs.next()){
			System.out.println("carId ="+rs.getLong(1));
		}
		connection.close();
		System.out.println("Car saved");
	}

	@Override
	public List<Car> getAllCar() throws SQLException {
		String query="select * from car ";
		Connection connection=dataSource.getConnection();
		ResultSet rs=connection.prepareStatement(query).executeQuery();
		List<Car> cars = new ArrayList<>();
		while(rs.next()){ 
			Car car= new Car();
			car.setCarId(rs.getLong("carId"));
			car.setModel(rs.getString("model"));
			car.setColor(rs.getString("color"));
			car.setPrice(rs.getDouble("price"));
			car.setEngine(engineRepository.getEngine(rs.getLong("engineId")));
			car.setManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
			cars.add(car);
		}
		connection.close();
		return cars;
	}

	@Override
	public Car getCar(Long carId) throws SQLException {
		String query="select * from car where carId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, carId);
		ResultSet rs=preparedStatement.executeQuery();
		Car car=null;
		if(rs.next()){ 
			car= new Car();
			car.setCarId(rs.getLong("carId"));
			car.setModel(rs.getString("model"));
			car.setColor(rs.getString("color"));
			car.setPrice(rs.getDouble("price"));
			car.setEngine(engineRepository.getEngine(rs.getLong("engineId")));
			car.setManufacturer(manufacturerRepository.getManufacturer(rs.getLong("manufacturerId")));
		}
		connection.close();
		return car;
	}

	@Override
	public void deleteCar(Long carId) throws SQLException {
		String query="delete from car where carId =? ";
		Connection connection=dataSource.getConnection();
		PreparedStatement preparedStatement=connection.prepareStatement(query);
		preparedStatement.setLong(1, carId);
		preparedStatement.executeUpdate();
		System.out.println("Car Deleted");
		connection.close();
	}
	
	
	//init-method
	public void dbinit() {
		String path = "dbscripts.sql";
		try (InputStream is=this.getClass().getClassLoader().getResourceAsStream(path);
				BufferedReader reader= new BufferedReader(new InputStreamReader(is));){
			List<String> queries= new ArrayList<String>();
			String line=reader.readLine();
			String query="";
			while(line!=null){
				query+=line;
				if(query.endsWith(";")){
					queries.add(query);
					//System.out.println(query);
					query="";
				}
				line=reader.readLine();
			}
			Connection connection=dataSource.getConnection();
			Statement statmement=connection.createStatement();
			for(String sql:queries){
				statmement.executeUpdate(sql);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}

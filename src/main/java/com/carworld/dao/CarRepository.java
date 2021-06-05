package com.carworld.dao;

import java.sql.SQLException;
import java.util.List;

import com.carworld.model.Car;

/**
 * @author: mmathew@manh.com
 */


public interface CarRepository {
	
	void addCar(Car car) throws SQLException;
	List<Car> getAllCar() throws SQLException;
	Car getCar(Long carId) throws SQLException;
	void deleteCar(Long carId) throws SQLException; 
}

package com.carworld.service;

import java.util.List;

import com.carworld.model.Car;
import com.carworld.model.Engine;
import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

public interface CarService {
	
	void addCar(Car car) throws Exception;
	List<Car> getAllCar() throws Exception;
	Car getCar(Long carId) throws Exception;
	void deleteCar(Long carId) throws Exception; 
	List<Engine> getAllEngine() throws Exception;
	List<Manufacturer> getAllManufacturer() throws Exception;

}

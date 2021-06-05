package com.carworld.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carworld.dao.CarRepository;
import com.carworld.model.Car;
import com.carworld.model.Engine;
import com.carworld.model.Manufacturer;

/**
 * @author: mmathew@manh.com
 */

@Service
public class CarServiceImpl implements CarService{

	//@Autowired -> Field DI through annotation config
	@Autowired
	CarRepository carRepository;
	
	@Autowired
	EngineService carEngineService;
	
	@Autowired
	ManufacturerService carManufacturerService;
	
	@Override
	public void addCar(Car car) throws Exception{
		carRepository.addCar(car);
	}

	@Override
	public List<Car> getAllCar() throws Exception{
			return carRepository.getAllCar();
	}

	@Override
	public Car getCar(Long carId) throws Exception{
			return carRepository.getCar(carId);
	}

	@Override
	public void deleteCar(Long carId) throws Exception{
		carRepository.deleteCar(carId);
	}

	@Override
	public List<Engine> getAllEngine() throws Exception{
		return carEngineService.getAllEngine();
	}

	@Override
	public List<Manufacturer> getAllManufacturer() throws Exception{
		return carManufacturerService.getAllManufacturer();
	}
	
}

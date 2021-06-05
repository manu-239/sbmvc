package com.carworld.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carworld.model.Car;
import com.carworld.service.CarService;
import com.carworld.service.EngineService;
import com.carworld.service.ManufacturerService;

/**
 * @author: mmathew@manh.com
 */
@Controller
public class CarController {
	
	CarController(){
		System.out.println("CarController");
	}
	
	@Autowired
	private CarService carService;

	@Autowired
	private EngineService engineService;

	@Autowired
	private ManufacturerService manufacturerService;

	@RequestMapping(value = {"/","/cars"})
	public ModelAndView getCarList() throws Exception {
		ModelAndView modelAndView = new ModelAndView("Cars");
		modelAndView.addObject("cars", carService.getAllCar());
		return modelAndView;
	}

	@RequestMapping(value = "/addcar", method = RequestMethod.GET)
	public ModelAndView getAddCarPage() throws Exception{
		ModelAndView modelAndView = new ModelAndView("AddCar");
		modelAndView.addObject("engines", carService.getAllEngine());
		modelAndView.addObject("manufactures", carService.getAllManufacturer());
		return modelAndView;
	}

	@RequestMapping(value = "/addcar", method = RequestMethod.POST)
	public ModelAndView saveCar(@ModelAttribute Car car, BindingResult result) throws Exception{
		ModelAndView modelAndView = new ModelAndView("Cars");
		car.setEngine(engineService.getEngine(Long.valueOf((String)result.getFieldValue("engine"))));
		car.setManufacturer(manufacturerService.getManufacturer(Long.valueOf((String)result.getFieldValue("manufacturer"))));
		carService.addCar(car);
		modelAndView.addObject("cars", carService.getAllCar());
		return modelAndView;
	}

	@RequestMapping("/delcar")
	public ModelAndView deleteCar(@RequestParam Long carId) throws Exception {
		carService.deleteCar(carId);
		ModelAndView modelAndView = new ModelAndView("Cars");
		modelAndView.addObject("cars", carService.getAllCar());
		return modelAndView;
	}

	@RequestMapping("/cardtl")
	public ModelAndView viewCar(@RequestParam Long carId) throws Exception {
		ModelAndView modelAndView = new ModelAndView("CarDetails");
		modelAndView.addObject("car", carService.getCar(carId));
		return modelAndView;
	}

}
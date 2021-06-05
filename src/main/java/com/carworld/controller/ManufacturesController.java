package com.carworld.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carworld.model.Manufacturer;
import com.carworld.service.ManufacturerService;

/**
 * @author: mmathew@manh.com
 */

@Controller
public class ManufacturesController{
	
	@Autowired
	ManufacturerService manufacturerService;


	@RequestMapping(value = "/manufactureslist", method = RequestMethod.POST)
	public ModelAndView getManufacturesList() throws Exception{
		ModelAndView modelAndView = new ModelAndView("Manufactures");
		modelAndView.addObject("manufactures", manufacturerService.getAllManufacturer());
		return modelAndView;
	}
	
	@RequestMapping(value = "/addmanufacturer", method = RequestMethod.GET)
	public ModelAndView getAddManufactures() throws Exception{
		ModelAndView modelAndView = new ModelAndView("AddManufacturer");
		return modelAndView;
	}
	
	@RequestMapping(value = "/addmanufacturer", method = RequestMethod.POST)
	public ModelAndView saveManufactures(@ModelAttribute Manufacturer manufacturer) throws Exception{
		ModelAndView modelAndView = new ModelAndView("Manufactures");
		manufacturerService.addManufacturer(manufacturer);
		modelAndView.addObject("manufactures", manufacturerService.getAllManufacturer());
		return modelAndView;
	}
	
	@RequestMapping("/delmanufacturer")
	public ModelAndView deleteManufactures(@RequestParam Long manufacturerId) throws Exception{
		ModelAndView modelAndView = new ModelAndView("Manufactures");
		manufacturerService.deleteManufacturer(manufacturerId);
		modelAndView.addObject("manufactures", manufacturerService.getAllManufacturer());
		return modelAndView;
	}
	
}
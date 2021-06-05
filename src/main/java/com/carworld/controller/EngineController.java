package com.carworld.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.carworld.model.Engine;
import com.carworld.service.EngineService;
import com.carworld.service.ManufacturerService;

/**
 * @author: mmathew@manh.com
 */
@Controller
@ControllerAdvice // @ModelAttribute methods to be shared across multiple @Controller classes. 
public class EngineController {
	
	@Autowired
	private EngineService engineService;
	
	@Autowired
	private ManufacturerService manufacturerService;
	
	//Used in <h1> of EnginesDetails.jsp, @ModelAttribute methods are invoked before the controller 
	//methods annotated with @RequestMapping are invoked 
	@ModelAttribute() 
	public void setMesg(Model model) {
		model.addAttribute("msg", "details");
	}
	
	@ModelAttribute("h1")//default name of the attribute will be camelCase of the return value 
	public String setAnotherMesg() {
		return " details";
	}
	
	
	@RequestMapping(value = "/enginelist", method = RequestMethod.POST)
	public ModelAndView getEnginelist() throws Exception {
		ModelAndView modelAndView = new ModelAndView("Engines");
		modelAndView.addObject("engines", engineService.getAllEngine());
		return modelAndView;
	}
	
	@RequestMapping("/enginedtl")
	public ModelAndView getEngineDetailById(@RequestParam Long engineId, Model model ) throws Exception{
		ModelAndView modelAndView = new ModelAndView("EnginesDetails");
		modelAndView.addObject("engine", engineService.getEngine(engineId));
		return modelAndView;
		
	}
	
	@RequestMapping(value = "/addengine", method = RequestMethod.GET)
	public ModelAndView getAddEngine() throws Exception{
		ModelAndView modelAndView = new ModelAndView("AddEngine");
		modelAndView.addObject("engineManufactures", manufacturerService.getAllManufacturer());
		return modelAndView;
	}
	
	@RequestMapping(value = "/addengine", method = RequestMethod.POST)
	public ModelAndView saveEngine(@ModelAttribute Engine engine,  BindingResult result) throws Exception{
		ModelAndView modelAndView = new ModelAndView("Engines");
		engine.setEngineManufacturer(manufacturerService.
				getManufacturer(Long.valueOf((String)result.getFieldValue("engineManufacturer"))));
		engineService.addEngine(engine);
		modelAndView.addObject("engines", engineService.getAllEngine());
		return modelAndView;
	}
	
	@RequestMapping("/delengine")
	public ModelAndView deleEngine(@RequestParam Long engineId) throws Exception{
		ModelAndView modelAndView = new ModelAndView("Engines");
		engineService.deleteEngine(engineId);
		modelAndView.addObject("engines", engineService.getAllEngine());
		return modelAndView;
	}

}
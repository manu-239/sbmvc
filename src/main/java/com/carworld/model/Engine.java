package com.carworld.model;

/**
 * @author: mmathew@manh.com
 */

public class Engine {

	private Long engineId;
	private String engineName = "Not avialble";
	private String engineType = "Not avialble";
	private int displacement;
	private Manufacturer engineManufacturer;
	
	
	public Long getEngineId() {
		return engineId;
	}
	public void setEngineId(Long engineId) {
		this.engineId = engineId;
	}
	public String getEngineName() {
		return engineName;
	}
	public void setEngineName(String engineName) {
		this.engineName = engineName;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public int getDisplacement() {
		return displacement;
	}
	public void setDisplacement(int displacement) {
		this.displacement = displacement;
	}
	public Manufacturer getEngineManufacturer() {
		return engineManufacturer;
	}
	public void setEngineManufacturer(Manufacturer engineManufacturer) {
		this.engineManufacturer = engineManufacturer;
	}
	
	
	
}

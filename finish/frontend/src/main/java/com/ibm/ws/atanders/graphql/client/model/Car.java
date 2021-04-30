package com.ibm.ws.atanders.graphql.client.model;

public class Car {

	private String vin;
	private String color;
	private String year;
	private String make;
	private String model;
	
	public Car() {}
	
	public Car(String vin, String color, String year, String make, String model) {
		this.vin = vin;
		this.color = color;
		this.year = year;
		this.make = make;
		this.model = model;
	}
	
	public String toString() {
		return "vin=" + vin + " " + color + " " + year + " " + make + " " + model;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public String getYear() {
		return year;
	}
	
	public void setYear(String year) {
		this.year = year;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getVin() {
		return vin;
	}
	
	public void setVin(String vin) {
		this.vin = vin;
	}
}
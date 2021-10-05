package com.ibm.ws.atanders.graphql.service.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Car")
@NamedQuery(name = "findAllCars", query = "SELECT c FROM Car c")
public class Car {

	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "vin")
	private String vin;
	
	@Column(name = "color")
	private String color;
	
	@Column(name = "modelYear")
	private String year;
	
	@Column(name = "make")
	private String make;
	
	@Column(name = "model")
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

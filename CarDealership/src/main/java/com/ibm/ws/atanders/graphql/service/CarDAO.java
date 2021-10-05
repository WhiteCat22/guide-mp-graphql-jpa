package com.ibm.ws.atanders.graphql.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.ibm.ws.atanders.graphql.service.model.Car;

@ApplicationScoped
public class CarDAO {

	@PersistenceContext(name = "jpa-unit")
    private EntityManager em;
	
	public List<Car> getCars() {
		return em.createNamedQuery("findAllCars", Car.class).getResultList();
    }
	
    public Car getCar(String vin) {
    	return em.find(Car.class, vin);
    }
	
	public Car addCar(Car newCar) {
		em.persist(newCar);
		return newCar;
	}
	
	public Car removeCar(String vin) {
		Car car = em.find(Car.class, vin);
		em.remove(car);
		return car;
	}
	
	public Car replaceCar(Car newCar) {
		Car oldCar = em.merge(newCar);
		return oldCar;
	}
}

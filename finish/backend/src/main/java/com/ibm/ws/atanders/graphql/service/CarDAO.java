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
		return em.createNamedQuery("Car.findALL", Car.class).getResultList();
    }
	
    public Car getCar(String vin) {
//    	return em.createNamedQuery("Car.lookupVin", Car.class)
//    			.setParameter("vin", vin)
//    			.getSingleResult();
    	return em.find(Car.class, vin);
    }
	
	public Car addCar(Car newCar) {
		System.out.println(newCar.toString());
		em.persist(newCar);
//		return em.find(Car.class, newCar.getVin());
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

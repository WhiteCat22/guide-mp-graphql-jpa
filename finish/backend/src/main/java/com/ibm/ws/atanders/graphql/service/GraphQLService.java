package com.ibm.ws.atanders.graphql.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import com.ibm.ws.atanders.graphql.service.model.Car;

@GraphQLApi
@ApplicationScoped
public class GraphQLService {
	
//	GraphQLService() {
//		if (inventory.size() == 0) {
//			inventory.add(new Car("123", "red", "2014", "Chevrolet", "Corvette"));
//		}
//	}
	
	@Inject
    private CarDAO inventory;
	
//	private static List<Car> inventory = new ArrayList<Car>();
	
	@Query
	@Transactional
    public List<Car> getCars() {
//		return inventory;
		return inventory.getCars();
    }
	
	@Query
	@Transactional
    public Car getCar(@Name("vin") String vin) {
//		System.out.println("get vin=" + vin);
//		System.out.println(inventory);
//		int index = getIndexOfCar(vin);
//        
//        if(index < 0)
//        	return null;
//        
//        Car car = inventory.get(index);
//        return car;
		
		return inventory.getCar(vin);
    }
	
	@Mutation
	@Transactional
	public Car addCar(@Name("newCar") Car newCar) {
//		System.out.println("adding car: " + newCar);
//		System.out.println(inventory);
//		inventory.add(newCar);
//		System.out.println(inventory);
//		return newCar;
		
		return inventory.addCar(newCar);
	}
	
	@Mutation
	@Transactional
	public Car removeCar(String vin) {
//		System.out.println("removing car: " + vin);
//		System.out.println(inventory);
//		int index = getIndexOfCar(vin);
//        
//        if(index < 0)
//        	return null;
//        
//        Car car = inventory.get(index);
//        inventory.remove(index);
//        
//        System.out.println(inventory);
//        
//        return car;
		
		return inventory.removeCar(vin);
	}
	
	@Mutation
	@Transactional
	public Car replaceCar(Car newCar) {
//		System.out.println("replacing car: " + newCar);
//		System.out.println(inventory);
//		int index = getIndexOfCar(newCar.getVin());
//        
//        if(index >= 0) {
//        	inventory.remove(index);
//        }
//        
//        inventory.add(newCar);
//        
//        System.out.println(inventory);
//        
//        return newCar;
		
		return inventory.replaceCar(newCar);
	}
	
//	private int getIndexOfCar(String vin) {
//		int index = 0;
//        for(Car car : inventory) {
//        	if (vin.toLowerCase().equals(car.getVin())) {
//        		return index;
//        	}
//        	index++;
//        }
//        return -1;
//	}
}

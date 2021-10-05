package com.ibm.ws.atanders.graphql.service;

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
	
	@Inject
    private CarDAO inventory;
	
	@Query("getAllCars")
	@Transactional
    public List<Car> getCars() {
		return inventory.getCars();
    }
	
	@Query("getCar")
	@Transactional
    public Car getCar(@Name("vin") String vin) {
		return inventory.getCar(vin);
    }
	
	@Mutation("newCar")
	@Transactional
	public Car addCar(@Name("newCar") Car newCar) {
		return inventory.addCar(newCar);
	}
	
	@Mutation("soldCar")
	@Transactional
	public Car removeCar(String vin) {
		return inventory.removeCar(vin);
	}
	
	@Mutation("tradeCar")
	@Transactional
	public Car replaceCar(Car newCar) {
		return inventory.replaceCar(newCar);
	}
}

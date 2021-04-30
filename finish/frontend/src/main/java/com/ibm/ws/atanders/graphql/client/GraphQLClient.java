package com.ibm.ws.atanders.graphql.client;

import java.util.List;

import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;
//import org.eclipse.microprofile.graphql.Query;

import com.ibm.ws.atanders.graphql.client.model.Car;

import io.smallrye.graphql.client.typesafe.api.GraphQlClientApi;

@GraphQlClientApi
public interface GraphQLClient {

//	  @Query
    public List<Car> getCars();
	
//    @Query
    public Car getCar(@Name("vin") String vin);
	
    @Mutation
	public Car addCar(@Name("newCar") Car newCar);
	
    @Mutation
	public Car removeCar(String vin);
	
    @Mutation
	public Car replaceCar(Car newCar);
}

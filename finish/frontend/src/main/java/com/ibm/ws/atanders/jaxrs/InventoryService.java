package com.ibm.ws.atanders.jaxrs;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.ibm.ws.atanders.graphql.client.GraphQLClient;
import com.ibm.ws.atanders.graphql.client.model.Car;

import io.smallrye.graphql.client.typesafe.api.GraphQlClientBuilder;

@Path("InventoryService")
public class InventoryService {
	
	private GraphQLClient client = GraphQlClientBuilder.newBuilder().build(GraphQLClient.class);
	
	@GET
	@Consumes("application/json")
	@Produces("application/json")
	public List<Car> getCars() {
		return client.getCars();
	}
	
	@GET
	@Consumes("application/json")
	@Produces("text/plain")
	public String getCar(@QueryParam("vin") String vin) {
		return client.getCar(vin).toString();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String addCar(@FormParam("vin") String vin,
			@FormParam("make") String make,
			@FormParam("model") String model,
			@FormParam("year") String year,
			@FormParam("color") String color) {
		Car newCar = new Car(vin, color, year, make, model);
		client.addCar(newCar);
		return newCar.toString();
	}
}

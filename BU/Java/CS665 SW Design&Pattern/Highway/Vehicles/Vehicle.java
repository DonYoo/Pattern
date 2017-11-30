package Vehicles;

import java.util.UUID;

import Highway_Toll.Constants;
import Highway_Toll.Tollgate;

public class Vehicle implements Vehicle_Interface{

	public String name;
	private int year;
	private int weight;
	private String uniqueID;
	public double monthly_statement;
	public double price;
	
	public Vehicle(){
		this.uniqueID = UUID.randomUUID().toString();
		this.price = Constants.base_price;
	}
	
	public void register_year(int year){
		this.year = year;
	}
	public void register_weight(int weight){
		this.weight = weight;
	}
	
	@Override
	public String getDescription() {
		return null;
	}

	@Override
	public double price() {
		return this.price;
	}
	
	public void resetStatement(){
		monthly_statement = 0;
	}
	
	public void passingToll(Tollgate eachToll){
		//passing toll
		//System.out.println("(Gate: " + eachToll.getuniqueID() + ", Car: " + this.uniqueID);
	}

	public void addPrice(double travelPrice) {
		monthly_statement += travelPrice;
	}
	
}

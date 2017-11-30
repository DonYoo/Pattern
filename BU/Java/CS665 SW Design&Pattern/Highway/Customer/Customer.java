package Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Vehicles.*;

/**
 * 
 * Car registration. Customers need to register their car and input some detail data about their
cars like the following (type, year, weight). A transponder will be send to the customer that has
to be mounted to car¡¯s front windshield.
- Transponders have unique IDs and one car has a single transponder.
- Customers may have multiple cars.
- Truck drivers should update the system with their latest load weight before driving on
highways
 * 
 */


public class Customer {
	
	private List<Vehicle>Customers;
	private int CustomerID;
	public static Random ran = new Random();
	
	public Customer(int i) {
		CustomerID = i;
		this.Customers = new ArrayList<>();
		
		int ranNumCars = 1+ ran.nextInt(2);	// random number of vehicle that customer owned.
		// create random number of vehicles
		for(int j=0; j<ranNumCars; j++){
			Vehicle Vehicles = new Vehicle();
			int TypeVehicle = 1 + ran.nextInt(3);
			
			// option can be added here.
			switch (TypeVehicle){
				case 1: 
					Vehicles = new Car();
					break;
				case 2:
					Vehicles = new Taxi();
					break;
				case 3:
					Vehicles = new Truck();
					break;
				case 4:
					Vehicles = new Van();
					break;
				default:
					break;
			}
			
			int year = 1987 + ran.nextInt(30);		//1987 ~ 2017
			Vehicles.register_year(year);
			int weight = 1000 + ran.nextInt(1000);	//kg
			Vehicles.register_weight(weight);
			
			this.register(Vehicles);
		}
	}
	
	public int getID(){
		return CustomerID;
	}
	
	public void register(Vehicle type){
		Vehicle vehicle = type;
		this.Customers.add(vehicle);
	}
	
	public void removeRegister(String name){
		for(int i =0; i<Customers.size(); i++){
			if(Customers.get(i).name == name){
				Customers.remove(i);
			}
		}
	}
	
	public double Monthly_Payment(){
		double payment = 0;
		for(Vehicle vehicle : Customers){
			payment += vehicle.monthly_statement;
		}
		return payment;
	}
	
	public void resetPayment(){
		for(Vehicle vehicle : Customers){
			vehicle.resetStatement();;
		}
	}
	
	public List<Vehicle> VehicleList(){
		return Customers;
	}

}

package Customer;

import java.util.ArrayList;
import java.util.Iterator;
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

	private List<Vehicle>VehicleList;
	private int CustomerID;
	public static Random ran = new Random();
	private VehicleFactory factory;
	private VehicleStore store;

	public Customer(int i) {
		CustomerID = i;
		this.VehicleList = new ArrayList<>();	
		factory = new VehicleFactory();
		store = new VehicleStore(factory);
	}

	public int getID(){
		return CustomerID;
	}

	public void register(){
		int ranNumCars = 1+ ran.nextInt(2);	// random number of vehicle that customer owned.
		// create random number of vehicles
		Vehicle Vehicles = null;

		// factory pattern
		for(int j=0; j<ranNumCars; j++){
			int TypeVehicle = 1 + ran.nextInt(3);
			Vehicles = store.orderVehicle(TypeVehicle);
		}
		this.VehicleList.add(Vehicles);
	}

	public void removeRegister(String name){
		//Iterator<Vehicle> iterator = VehicleList.iterator();
		
		for(int i =0; i<VehicleList.size(); i++){
			if(VehicleList.get(i).name == name){
				VehicleList.remove(i);
			}
		}
	}

	public double Monthly_Payment(){
		double payment = 0;
		for(Vehicle vehicle : VehicleList){
			payment += vehicle.monthly_statement;
		}
		return payment;
	}

	public void resetPayment(){
		for(Vehicle vehicle : VehicleList){
			vehicle.resetStatement();;
		}
	}

	public List<Vehicle> VehicleList(){
		return VehicleList;
	}

}

package Highway_Toll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import Customer.Customer;
import Vehicles.Vehicle;

public class TollCollector {
	Random ran = new Random();
	private static TollCollector tollCollector;
	// make 10 highways
	private Highway[] Highways;
	private Customer[] customers;

	private TollCollector (){

	}

	// Providing Global point of access
	// singleton pattern.
	public static TollCollector getSingletonInstance() {
		if (null == tollCollector) {
			tollCollector = new TollCollector();
		}
		return tollCollector;
	}

	// make a highway, factory pattern.
	public void makeHighway(int count){
		Highways = new Highway[count];
		for(int i=0; i<count; i++){
			Highways[i] = new Highway();
			Highways[i].BuildTollgate();
		}
	}

	public Highway[] getHighways(){
		return Highways;
	}

	public void registerCustomer() {
		// make 10 customers
		customers = new Customer[Constants.number_customer];
		for(int i=0; i<Constants.number_customer; i++){
			customers[i] = new Customer(i);
			// register random number of cars for each customer
			customers[i].register();
		}
	}
	
	public Customer[] getCustomers(){
		return customers;
	}
}

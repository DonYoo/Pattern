package Highway_Toll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Customer.Customer;
import Vehicles.*;

/*
 * 
 *Driving distance calculation. Highways can be modeled as graphs that are divided by
different segments. Each highway is a two-direction highway. The direction of cars can be
identified when they pass two gateways in a specific direction.
- Each highway segment has a specific travel distance and a base price that can be stored like
(Gate_ID_1, Gate_ID_2, distance_in_miles, price_in_US_Dollar)
 *
 */

/*
 * Monthly statement. A monthly statement should be calculated for each customer based on the
customer cars and driving distances.
- If a driver travels a longer distance of at least 5 segments in a specific direction in the same
day, he gets 10% discount in toll calculation for that travel.
- Monthly statements should include the total price and total travel distance on the highways in
that month.
 */


public class Main {

	public static Random ran = new Random();
	
	public static void main(String[] args) {
		
		// make 10 highways
		Highway[] Highways = new Highway[10];

		for(int i=0; i<Constants.number_highway; i++){
			Highways[i] = new Highway(Constants.highway_miles);
		}
		
		// make 10 customers
		Customer[] customers = new Customer[Constants.number_customer];
		for(int i=0; i<Constants.number_customer; i++){
			customers[i] = new Customer(i);
		}

		TollCollector ETC = new TollCollector();
		
		// simulate 9 months.
		for(int month =0; month<Constants.time_period; month++){
			// ncst = number of customers
			for(Customer customer : customers){
				for(Vehicle vehicle : customer.VehicleList()){
					int timestravel = ran.nextInt(Constants.number_highway);
					for(int i =0; i<timestravel; i++){
						
						double endPoint = ran.nextDouble()*Constants.highway_miles;
						double startPoint = ran.nextDouble()*(Constants.highway_miles - endPoint);
						int whichHighway = ran.nextInt(Constants.number_highway);
						
						ETC.travel(vehicle, startPoint, endPoint, Highways[whichHighway]);
					}	
				}
				System.out.println("Customer "+ customer.getID()+ ", "+(month+1)+" Monthly Payment : " + customer.Monthly_Payment());
				customer.resetPayment();
			}
		}
	}
}

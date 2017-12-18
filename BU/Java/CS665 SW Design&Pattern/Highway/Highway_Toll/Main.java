package Highway_Toll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

import Customer.Customer;
import Vehicles.*;

/**
 * 
 * @author DonYoo
 *I think your design needs a refactoring. 

- Also take a look at your class diagram. The realization is not correctly shown. The associations have no labels so that the meaning of the associations lines is not clear. 

- Not every composition is a composite pattern. You need to have tree structure. take a look at the slides of the composite pattern.

- having a price method in Vehicle class would mean more the vehicle price and not the toll cost of passing a segment highway.  


- You can use multiple patterns, like factory patterns, singleton for the main TollGateSystem, Iterator (as you used), visitor for price and distance calculation. 



If you take time and refactor and redesign your solution I would accept it and improve your grade. 


 */
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

/*
 * use the visitor pattern.
 * 
 * 2 different visitor 
 * 1 for distance.
 * 1 for cost.
 * 
 * decorator pattern for vehicle
 * 
 */
public class Main {
	public static Random ran = new Random();

	public static void main(String[] args) {

		// singleton pattern.		
		TollCollector ETC = TollCollector.getSingletonInstance();
		ETC.makeHighway(Constants.number_highway);
		ETC.registerCustomer();

		// simulate 9 months.
		for(int month =0; month<Constants.time_period; month++){
			// ncst = number of customers
			for(Customer customer : ETC.getCustomers()){
				for(Vehicle vehicle : customer.VehicleList()){
					int timestravel = ran.nextInt(Constants.number_highway);
					for(int i =0; i<timestravel; i++){

						double endPoint = ran.nextDouble()*Constants.highway_miles;
						double startPoint = ran.nextDouble()*(Constants.highway_miles - endPoint);

						// get random highway.
						Highway highway = ETC.getHighways()[ran.nextInt(Constants.number_highway)];

						vehicle.travel(startPoint, endPoint, highway);
					}	
				}
				System.out.println("Customer "+ customer.getID()+ ", "+(month+1)+" Monthly Payment : " + customer.Monthly_Payment());
				customer.resetPayment();
			}
		}
	}
}

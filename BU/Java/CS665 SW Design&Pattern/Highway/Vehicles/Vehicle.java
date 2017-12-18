package Vehicles;

import java.util.ArrayList;
import java.util.UUID;

import Highway_Toll.Constants;
import Highway_Toll.Highway;
import Highway_Toll.Tollgate;

public abstract class Vehicle implements Vehicle_Interface{

	public String name;
	private int year;
	private int weight;
	private String uniqueID;
	public double monthly_statement;

	
	public Vehicle(){
		this.uniqueID = UUID.randomUUID().toString();
		
	}
	
	public void register_year(int year){
		this.year = year;
	}
	public void register_weight(int weight){
		this.weight = weight;
	}
	
	public void resetStatement(){
		monthly_statement = 0;
	}
	
	public double passingToll(Tollgate eachToll){
		//passing toll
		//System.out.println("(Gate: " + eachToll.getuniqueID() + ", Car: " + this.uniqueID);
		double price = 0;
		
		price = eachToll.price(this);
		return price;
	}

	public void addPrice(double travelPrice) {
		monthly_statement += travelPrice;
	}
	
	public String toString(){
		StringBuffer display = new StringBuffer();
		display.append("---- " + name + " ----\n");
		display.append(year + "\n");
		display.append(weight + "\n");
		return display.toString();
	}
	
	public void travel(double startPoint, double endPoint, Highway highway){
		ArrayList<Tollgate> Tollgates = highway.TollgateList;
		Tollgate StartToll = null;
		Tollgate EndToll = null;
		double travelPrice = 0;
		int discount = 5; 

		// if vehicle is moving positive direction
		if( (endPoint - startPoint) > 0){
			for(Tollgate eachToll : Tollgates){
				double tollPosition = eachToll.getPosition();
				if((tollPosition >= startPoint) && (tollPosition < endPoint)){
					discount--;
					if(StartToll == null){
						StartToll = eachToll; 
					}
					EndToll = eachToll;
					travelPrice += passingToll(eachToll);
				}
			}
		}
		
		// if vehicle is moving negative direction
		else{
			for(int i=Tollgates.size()-1; i>=0 ; i--){
				Tollgate eachToll = Tollgates.get(i);
				double tollPosition = eachToll.getPosition();
				if((tollPosition <= startPoint) && (tollPosition > endPoint)){
					discount--;
					if(StartToll == null){
						StartToll = eachToll; 
					}
					EndToll = eachToll;
					travelPrice += passingToll(eachToll);
				}
			}
		}
		/*
		 * If a driver travels a longer distance of at least 5 segments in a specific direction in the same
		 day, he gets 10% discount in toll calculation for that travel.
		 */
		if(discount < 0){
			travelPrice  *= .9;
		}
		addPrice(travelPrice);

		if(StartToll != null){
			// this is display for the driving distance calculation
			/*
			System.out.println("(Gate1 : " + StartToll.getuniqueID() + ", Gate2 : " + EndToll.getuniqueID() + 
					", " + (endPoint - startPoint) + ", " + travelPrice);
			 */
		}
	}

}

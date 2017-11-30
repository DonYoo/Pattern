package Highway_Toll;

import java.util.ArrayList;
import java.util.Random;

import Vehicles.Vehicle;

public class TollCollector {
	Random ran = new Random();
	
	public TollCollector (){
		
	}

	public void travel(Vehicle eachVehicle, double startPoint, double endPoint, Highway Highways){
		
		ArrayList<Tollgate> Tollgates = Highways.TollgateList;
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
					eachVehicle.passingToll(eachToll);
					travelPrice += eachVehicle.price();
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
					eachVehicle.passingToll(eachToll);
					travelPrice += eachVehicle.price();
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
		eachVehicle.addPrice(travelPrice);
		
		if(StartToll != null){
			// this is display for the driving distance calculation
			/*
			System.out.println("(Gate1 : " + StartToll.getuniqueID() + ", Gate2 : " + EndToll.getuniqueID() + 
					", " + (endPoint - startPoint) + ", " + travelPrice);
					*/
		}
	}

}

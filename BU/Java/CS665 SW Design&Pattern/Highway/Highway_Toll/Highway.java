package Highway_Toll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

/**
 * Highways, Toll gates and Data Collection: Each highway is segmented in multiple toll
gateways (or data collection points) and each toll gate has a position unique ID.
When a car is passing a toll gate, the following data is collected:
(Gate_ID, car_transponder_ID )
 */

public class Highway {
	
	private double distance;
	public ArrayList <Tollgate> TollgateList;
	private Random ran = new Random();
	private TollgateFactory tollgateFactory;
	
	public Highway(){
		TollgateList = new ArrayList<>();
		tollgateFactory = new TollgateFactory();
		
		/*
		//toll positions make sure this is in order
		for(int j=0; j<Constants.number_tollgates; j++){
			System.out.println(Highways[0].TollgateList.get(j).getPosition());		
		}
		*/
	}

	public void BuildTollgate() {
		// make 10 toll gates for each highway.
		Tollgate toll = new Tollgate();
		for(int j=0; j<Constants.number_tollgates; j++){
			double tollposition = ran.nextDouble()*Constants.highway_miles;
			toll = tollgateFactory.createTollgate();
			toll.setPosition(tollposition);
			TollgateList.add(toll);
		}
	}

	public static Comparator<Tollgate> TollgateCompare = new Comparator<Tollgate>() {
	
			public int compare(Tollgate T1, Tollgate T2) {
			   double StudentName1 = T1.getPosition();
			   double StudentName2 = T2.getPosition();

			   if(StudentName1 < StudentName2){
				   return -1;
			   }
			   else if(StudentName1 > StudentName2){
				   return 1;
			   }
		   return 0;
		   }};		
}

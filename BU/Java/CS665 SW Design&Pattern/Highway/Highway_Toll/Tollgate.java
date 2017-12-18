package Highway_Toll;

import java.util.UUID;

import Vehicles.*;

public class Tollgate {

	private double position;
	private String uniqueID;
	private double price;
	
	public Tollgate() {
		this.uniqueID = UUID.randomUUID().toString();
		this.price = Constants.base_price;
	}

	public void setPosition(double tollposition){
		this.position = tollposition;
	}
	
	public double getPosition(){
		return position;
	}
	
	public String getuniqueID(){
		return uniqueID;
	}

	public double price(Vehicle type) {
		if(type instanceof Car){
			if(((Car) type).trailer() == true){
				price *= 2;
			}
			return price;
		}

		if(type instanceof Taxi){
			return price * 0.5;
		}
		
		if(type instanceof Truck){
			return price * 2
					+ ((Truck)type).getWeight() * price;
		}
		
		if(type instanceof Van){
			return price * 1.5;
		}
		return price;
	}
}

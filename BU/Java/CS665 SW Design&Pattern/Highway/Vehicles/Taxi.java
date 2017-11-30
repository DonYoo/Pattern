package Vehicles;

public class Taxi extends Vehicle{

	@Override
	public String getDescription() {
		return "Taxi";
	}
	
	@Override
	public double price() {
		return price * 0.5;
	}

}

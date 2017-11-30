package Vehicles;

public class Van extends Vehicle{

	@Override
	public String getDescription() {
		return "Van";
	}

	@Override
	public double price() {
		return price * 1.5;
	}
	
}

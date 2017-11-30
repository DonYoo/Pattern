package Vehicles;

public class Truck extends Vehicle{

	private double tons = 0;
	
	@Override
	public String getDescription() {
		return "Truck";
	}

	@Override
	public double price() {
		return price * 2
				+ this.tons * price;
	}
	
	public void setWeight(double tons){
		this.tons = tons;
	}

}

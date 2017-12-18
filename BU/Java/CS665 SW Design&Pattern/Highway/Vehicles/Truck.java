package Vehicles;

public class Truck extends Vehicle{

	private double tons = 0;
	
	@Override
	public String getDescription() {
		return "Truck";
	}

	
	public void setWeight(double tons){
		this.tons = tons;
	}

	public double getWeight(){
		return tons;
	}
}

package Vehicles;

public class Car extends Vehicle{

	private boolean trailer = false;
	
	@Override
	public String getDescription() {
		return "Car";
	}
	
	@Override
	public double price() {
		if(trailer == true){
			price *= 2;
		}
		return price;
	}
	
	public void setTrailer(String set){
		if(set.equals("yes")){
			trailer = true;
		}
		else{
			trailer = false;
		}
	}
}

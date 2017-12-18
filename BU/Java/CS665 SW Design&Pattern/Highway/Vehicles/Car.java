package Vehicles;

public class Car extends Vehicle{

	public boolean trailer = false;
	
	@Override
	public String getDescription() {
		return "Car";
	}
	
	public void setTrailer(String set){
		if(set.equals("yes")){
			trailer = true;
		}
		else{
			trailer = false;
		}
	}
	
	public String toString(){
		StringBuffer display = new StringBuffer();
		display.append(super.toString());
		if(trailer == true)
			display.append("trailer" + "\n");
		return display.toString();
	}
	
	public boolean trailer(){
		return trailer;
	}
}

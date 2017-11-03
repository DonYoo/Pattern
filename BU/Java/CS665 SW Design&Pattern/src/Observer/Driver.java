package Observer;

import java.util.Random;

public class Driver implements MyObserver{
    private int position;
    
    public Driver(){
    	Random ran = new Random();
    	this.position = ran.nextInt(Fast_Delivery.citysize) + 1;
    }
    
    public int getPosition(){
    	return position;
    }
	public String Type() {
		return "Cars";
	}
	
	@Override
	public void update(Object customer) {
		
	}
}

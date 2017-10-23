package Observer;
import java.util.Random;

// Observer of Manager / Manager for Drivers.
public class Store extends CommonObservable implements MyObserver
{
    private int position;
    private boolean Traffic = false;
    
    Random ran = new Random();

    public Store(){
    	this.position = ran.nextInt(Fast_Delivery.citysize) + 1;
    }
    
    public void update (Object obj)
    {
    	// if its a call from Website
    	if(obj instanceof Customer){
    		this.customer = (Customer) obj;
    		System.out.println("Store "+position+" Received an order: "+ customer.getOrder());
    		MyObserver nearestDriver = new Driver();
    		MyObserver nearestVan = new Van_Driver();
    		
    		int shortestDistance = Integer.MAX_VALUE;
    		int shortestVan = Integer.MAX_VALUE;

    		for (MyObserver driver : observers) {
    			int current = Math.abs(position-driver.getPosition());
    			// find nearest Van.
    			if(driver.Type() == "V"){
    				if(current < shortestVan){
    					shortestVan = current;
        				nearestVan = driver;
        			}
    			}
    			// find nearest Drivers.
    			if(current < shortestDistance){
    				shortestDistance = current;
    				nearestDriver = driver;
    			}
    		}
    		// if its frozen food with delivery range father than 2 miles or Traffic jam event, go to Van
    		if(customer.isFronze() && 
    				((shortestDistance > 2) || (Traffic == true)) ){
    			if(Traffic){
    				System.out.println("Traffic Jam, deliver would take longer than usual");
    			}
    			nearestDriver = nearestVan;
    		}
    		notifyObserver(nearestDriver);
    	}
    	
    	else if (obj instanceof String){
    		if(obj.equals("traffic")){
    			this.Traffic = true;
    		}
    		else if(obj.equals("clear")){
    			this.Traffic = false;
    		}
    	}
    	
		
        /* this is for regular observer class in java 
         * setChanged()
         * the setchanged() is used as indication or flag for changing the state. 
         * if it true the notifyObservers() can run and update all the observers.
         * if it false the notifyObservers() is called without calling the setchanged()
         * and the observers will not be notified.
         
        setChanged();
        notifyObservers();
        
        */
    }
    
    public int getPosition(){
    	return position;
    }

	@Override
	public String Type() {
		return "S";
	}
}
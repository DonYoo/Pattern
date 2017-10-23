package Observer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Fast_Delivery
{
	public static int citysize = 100;
	public static int rangemile = citysize/2;
	public static int numberofStore = 5;
	public static int numberofDriver = 10;
	public static int numberofCustomer = 10;
	
    public static void main(String args[])
    {
    	// simulator
    	Random ran = new Random();
    	int numberOfVan = ran.nextInt(numberofDriver) + 1;
    	int randomTraffic = ran.nextInt(numberofCustomer);
    	
    	// create customer
    	final Customer []Customers = new Customer[numberofCustomer];
    	for(int i=0; i<numberofCustomer; i++){
    		Customers[i] = new Customer(i);
        }
    	// create observers stores.
        final Store []Stores = new Store[numberofStore];
        for(int i=0; i<numberofStore; i++){
        	Stores[i] = new Store();
        }
    	// create observers Van & Taxi drivers.
        final Driver []Drivers = new Driver[numberofDriver];
        for(int i=0; i<numberOfVan; i++){
        	Drivers[i] = new Van_Driver();
        }
        for(int i=numberOfVan; i<numberofDriver; i++){
        	Drivers[i] = new Taxi_Driver();
        }
        
        // add Driver subscribe Stores
        for(int i=0; i<numberofStore; i++){
        	Stores[i].registerObserver(Drivers[i]);
        	
    		for (Driver driver : Drivers) {
    			int range = Math.abs(Stores[i].getPosition()-driver.getPosition());
    			// add only drivers within half if citysize range.
    			if(range < rangemile){
    				Stores[i].registerObserver(driver);
    			}
    		}
        }
        
        // Sort Stores and Driver for display.
        Arrays.sort(Stores, new Comparator<MyObserver>(){
			@Override
			public int compare(MyObserver s1, MyObserver s2) {
				return s1.getPosition() - s2.getPosition();
			}
    	});
        Arrays.sort(Drivers, new Comparator<MyObserver>(){
			@Override
			public int compare(MyObserver s1, MyObserver s2) {
				return s1.getPosition() - s2.getPosition();
			}
    	});
        
    	System.out.println("Store position, S for Store");
    	System.out.println("driver position, V for Van T for Taxi");
    	
    	// Display
    	// Store position.
    	displayPosition(Stores, numberofStore);
    	displayPosition(Drivers, numberofDriver);
    	
    	
        System.out.println("\nGreeting Customer. Our menu offers "
        		+ "\nHamburger, Pizza, Ice Cream, Forzen Chicken and Birthday Cake\n"
        		+ "Special deal with Birthday Cake. It comes with chocolate boxes and a flower bouquet.\n"
        		+ "What do you want to order?");

        // init the event generator. get the text from stdin
        final Website Website = new Website();

        // add stores as subscribe to Website  
        for(int i =0; i< numberofStore; i++){
        	Website.registerObserver(Stores[i]);
        }
        
        final Traffic traffic = new Traffic();
        
        // add stores as subscribe to Traffic control
        for(int i =0; i< numberofStore; i++){
        	traffic.registerObserver(Stores[i]);
        }
        
        // orders from customers
        for(int i=0; i<numberofCustomer; i++){
        	
        	Customer customer = Customers[i];
        	customer.order();
        	if(i == randomTraffic){
        		traffic.setTraffic();
        	}
        	Website.setOrder(customer);
        	if(i == randomTraffic){
        		traffic.clearTraffic();
        	}
        }
    }
    
    public static void displayPosition(Object []array, int size){
    	int previous =0;
    	int between =0;
    	for(int i=0; i<size; i++){
    		if(array[i] instanceof MyObserver){
    			int position = ((MyObserver) array[i]).getPosition();
        		between = position - previous;
        		for(int space =0; space<between; space++){
        			System.out.print(" ");
        		}
        		System.out.print(((MyObserver) array[i]).Type() + position+ " ");
        		// display if distance is larger than 10, it has to display S10 which is 3 letter so give them 3 space.
        		if(position <10){
        			previous = position+3;
        		}
        		else{
        			previous = position+4;
        		}
    		}
    	}
    	System.out.println();
    }
}
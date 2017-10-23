package Observer;

import java.util.Random;
import java.util.Scanner;

public class Customer {
	private int CustomerNumber;
	private int CustomerPosition;
	private Scanner in;
	private String Order;
	private boolean frozen;
	private boolean birthday;
	
	Random ran = new Random();
	
	public Customer(int number){
		CustomerNumber = number;
		CustomerPosition = ran.nextInt(Fast_Delivery.citysize) + 1;
		frozen = false;
		birthday = false;
	}
	public void order(){
		in = new Scanner(System.in);
		System.out.print("\nCustomer "+ CustomerNumber+ " (position "+CustomerPosition +") order : ");
		Order = in.nextLine();
		if(Order.equals("Ice Cream") || Order.equals("Forzen Chicken")){
			frozen = true;
		}
		else if(Order.equals("Birthday Cake")){
			birthday = true;
		}
	}
	public String getOrder(){
		return Order;
	}
	public int getPosition(){
		return CustomerPosition;
	}
	public int getNumber(){
		return CustomerNumber;
	}
	public boolean isFronze(){
		return frozen;
	}
	public boolean isBirthday(){
		return birthday;
	}

}

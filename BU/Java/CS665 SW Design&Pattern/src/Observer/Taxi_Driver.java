package Observer;

public class Taxi_Driver extends Driver
{
    public Taxi_Driver() {
	}
    
    @Override
    public String Type(){
    	return "T";
    }
    @Override
    public void update (Object customer)
    {
    	if(customer instanceof Customer){
			System.out.print("Taxi "+getPosition()+" is Delivering "+ ((Customer) customer).getOrder());
			if(((Customer) customer).isBirthday()){
				System.out.print(" with Chocolate and a flower");
			}
			System.out.println(" to Customer "+((Customer) customer).getNumber());
			((Customer) customer).notice(this);
		}
    }
}

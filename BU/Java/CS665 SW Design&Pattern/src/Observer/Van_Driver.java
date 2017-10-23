package Observer;

public class Van_Driver extends Driver
{
    public Van_Driver() {
	}
    
    public String Type(){
    	return "V";
    }
	@Override
	public void update(Object customer) {
		if(customer instanceof Customer){
			System.out.print("Van "+getPosition()+" is Delivering "+ ((Customer) customer).getOrder());
			if(((Customer) customer).isBirthday()){
				System.out.print(" with Chocolate and a flower");
			}
			System.out.println(" to Customer "+((Customer) customer).getNumber());
			
		}
	}
}
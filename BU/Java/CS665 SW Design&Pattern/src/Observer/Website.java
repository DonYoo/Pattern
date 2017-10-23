package Observer;

public class Website extends CommonObservable
{
	public void setOrder(Customer customer) {
		this.customer = customer;
		FindNearestStore();
	}
	private void FindNearestStore() {
		MyObserver nearest = new Store();
		int shortest = Integer.MAX_VALUE;
		
		for (MyObserver store : observers) {
			int current = Math.abs(store.getPosition()-customer.getPosition());
			if(current < shortest){
				shortest = current;
				nearest = store;
			}
		}
		notifyObserver(nearest);
	}
}


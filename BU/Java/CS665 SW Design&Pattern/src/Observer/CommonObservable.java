package Observer;

import java.util.ArrayList;
import java.util.List;

public class CommonObservable implements MyObservable{

	public List<MyObserver> observers;
	public Customer customer;
	
	public CommonObservable() {
		observers = new ArrayList<MyObserver>();
	} 
	public void registerObserver(MyObserver o) {
		observers.add(o);
	}
	public void removeObserver(MyObserver o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
		observers.remove(i);
		}
	}
	public void notifyObserver(MyObserver observer) {
		observer.update(customer);
	}
}

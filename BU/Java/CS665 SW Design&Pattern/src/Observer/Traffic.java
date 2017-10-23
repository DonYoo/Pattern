package Observer;

public class Traffic extends CommonObservable{
	
	public void setTraffic(){
		for (MyObserver store : observers) {
			store.update("traffic");
		}
	}
	public void clearTraffic(){
		for (MyObserver store : observers) {
			store.update("clear");
		}
	}
}

package Observer;

public interface MyObservable {
	public void registerObserver(MyObserver o);
	public void removeObserver(MyObserver o);
	public void notifyObserver(MyObserver observer);
}

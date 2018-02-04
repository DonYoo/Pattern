package Adapter;

// Client
public class Main {

	public static void main(String[] args) {
		Adaptee socket = new Socket("female", 0.25);
		Adapter adapter = new Adapter(socket);
		Ratchet ratchet = new Ratchet("male", 0.5, adapter);
		
		socket.drive();
		adapter.screw();
		ratchet.screw();
	}
	
}

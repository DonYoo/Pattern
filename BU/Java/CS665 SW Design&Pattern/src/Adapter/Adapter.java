package Adapter;

// adapter = middleware
// ratchet to socket

public class Adapter implements Target{
	Adaptee adaptee;
	
	Adapter(Adaptee adaptee){
		this.adaptee = adaptee;
	}

	@Override
	public void screw() {
		System.out.println("Adapter screw");
		adaptee.drive();	
	}
}

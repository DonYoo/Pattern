package Adapter;

// adapter = middleware
public class Adapter implements Adaptee{
	Target socket;
	Adapter(Target socket){
		this.socket = socket;
	}
	@Override
	public void drive(int num) {
		char letter = (char)num;
		socket.drive(letter);
	}

}

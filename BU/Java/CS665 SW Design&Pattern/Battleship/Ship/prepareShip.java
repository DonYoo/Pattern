package Ship;

public class prepareShip {
	ManufactureShip factory;

	public prepareShip(ManufactureShip factory) {
		this.factory = factory;
	}
	public Ship orderShip(String type) {
		Ship ship;
		ship = factory.createShip(type);
		
		return ship;
	}    
}

package Ship;

public class ManufactureShip {

	public Ship createShip(String type) {
		Ship ship = null;
		if (type.equals("Ferry")) {
			ship = new Ferry();
		} 
		else if (type.equals("Battleship")) {
			ship = new Battleship();
		} 
		else if (type.equals("Submarine")) {
			ship = new Submarine();
		} 
		return ship;
	}
}

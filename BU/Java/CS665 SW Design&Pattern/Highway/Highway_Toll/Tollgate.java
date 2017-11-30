package Highway_Toll;

import java.util.UUID;

public class Tollgate {

	private double position;
	private String uniqueID;
	
	public Tollgate(double tollposition) {
		this.uniqueID = UUID.randomUUID().toString();
		this.position = tollposition;
	}
	
	public double getPosition(){
		return position;
	}
	
	public String getuniqueID(){
		return uniqueID;
	}

}

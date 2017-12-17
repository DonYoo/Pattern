package Command;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import Ship.Ship;
import battleship.Player;
import battleship.Constants;

public class Attack implements BattleshipCommand {
	
	private Player opponent;
	private Scanner s;
	private Map<Point, Boolean> History;

	public Attack (Player opponent){
		this.opponent = opponent;
		this.History = new HashMap<>();	// for keeping the shots record.
		s = new Scanner(System.in);
	}
	
	@Override
	public void execute() {
		System.out.println("\n\nChoose coordinates you want to shots (x y) ");
         
        Point point = OutofRange();
        
        History.put(point, true);	// record this position is shoted.
        
        
        // update board status.
        Ship ship = opponent.update(point);
        boolean isShipHit = (ship != null) ? true : false;
        System.out.print("Shoot, targets (" +(int)point.getX() +", "+(int)point.getY()+")");
        System.out.println("...and " + ((isShipHit) ? "HITS!" : "misses..."));
        
        if(isShipHit) {
            ship.shipWasHit();
            opponent.decrementLiveByOne();
        }
    }

	private Point isShotted(Point point) {
		while(History.get(point) != null) {
            System.out.print("This position has already been Shots");
            point = new Point(s.nextInt(), s.nextInt());
        }
		return point;
	}

	private Point OutofRange() {
		Point point = new Point(s.nextInt(), s.nextInt());
        
		boolean withinRange = false;
		while(withinRange == false){
			while( !((Constants.BOARD_ROWS>=point.getX()) && (Constants.BOARD_ROWS <=point.getX()) &&
	    			(Constants.BOARD_COLUMNS>=point.getY()) && (Constants.BOARD_COLUMNS <=point.getY()))){
	    		System.out.println("Out of range. Try again.");
	    		point = new Point(s.nextInt(), s.nextInt());
	    	}
			withinRange = true;
			if(History.get(point) != null) {
	            System.out.print("This position has already been Shots");
	            withinRange = false;
	        }
		}
		return point;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

}

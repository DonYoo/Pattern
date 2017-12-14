package battleship;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Player {
    private int id;
    private int lives;
    private Board board;
    private Map<Point, Boolean> History;
    private Scanner s;

    /**
     * Instantiates a new Player.
     * id, lives, board, History
     */
    public Player(int id) {
        System.out.println("\n=== Setting up everything for Player "+id+" ====");
        this.s = new Scanner(System.in);
        this.id = id;
        this.board = new Board();
        this.lives = Constants.PLAYER_LIVES;
        this.History = new HashMap<>();	// for keeping the shots record.
    }

    /**
     * Gets id.
     */
    public int getId() {
        return id;
    }

    /**
     * Gets lives.
     */
    public int getLives() {
        return lives;
    }

    /**
     * Decrement live by one from hit.
     */
    public void decrementLiveByOne() {
        lives--;
    }

    /**
     * Turn to play.
     */
    public void turnToPlay(Player opponent) {
        System.out.println("\n\nPlayer "+id+" Choose coordinates you want to shots (x y) ");
        Point point = new Point(s.nextInt(), s.nextInt());

        while(History.get(point) != null) {
            System.out.print("This position has already been Shots");
            point = new Point(s.nextInt(), s.nextInt());
        }
        attack(point, opponent);
    }

    /**
     * Attack
     */
    private void attack(Point point, Player opponent) {
        Ship ship = opponent.board.targetShip(point);
        boolean isShipHit = (ship != null) ? true : false;

        History.put(point, isShipHit);	// record this position is shoted.
        System.out.print("Player "+id+", targets (" +(int)point.getX() +", "+(int)point.getY()+")");
        System.out.println("...and " + ((isShipHit) ? "HITS!" : "misses..."));
        
        if(isShipHit) {
            ship.shipWasHit();
            opponent.decrementLiveByOne();
        }
    }
}
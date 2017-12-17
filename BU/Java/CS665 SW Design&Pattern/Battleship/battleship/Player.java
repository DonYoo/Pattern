package battleship;

import java.awt.Point;
import Command.*;
import Ship.Ship;

public class Player {
    private int id;
    private int lives;
    private Board board;
    private Player opponent;
    
    BattleRemoteControl RemoteControl;
    

    /**
     * Instantiates a new Player.
     * id, lives, board, History
     */
    public Player(int id) {
        System.out.println("\n=== Setting up everything for Player "+id+" ====");
        this.id = id;
        // create board and ship position
        this.board = new Board();
        this.lives = Constants.PLAYER_LIVES;
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
     * @return 
     */
    public Ship update(Point point) {
    	return board.targetShip(point);
    }

	public void setOpponent(Player player) {
		this.opponent = player;
		
        BattleshipCommand Attack_command = new Attack(opponent);
        RemoteControl = new BattleRemoteControl();

        // set attack command in 0.
        RemoteControl.setCommand(0, Attack_command);
	}
	
	public void Attack(){
        RemoteControl.AttackButton(0);
	}   
}
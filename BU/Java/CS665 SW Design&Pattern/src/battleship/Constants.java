package battleship;

import java.util.Scanner;

public class Constants {

    public static int PLAYER_LIVES; //sum of all the ships

    public static int Ferry_SIZE = 2;
    public static int BATTLESHIP_SIZE = 4;
    public static int SUBMARINE_SIZE = 3;

    public static final char SHIP_ICON = 'S';
    public static final char WATER_ICON = '-';
    public static final char SHIP_IS_HIT_ICON = 'X';
    public static final char SHOT_NOTHING_ICON = '*';

    public static final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    public static int BOARD_ROWS;
    public static int BOARD_COLUMNS;
    
    private Scanner s;
        
    public Constants() {
    	s = new Scanner(System.in);
    }

	public void setup() {
    	System.out.println("Select Board Size (x y). ex) 5 5, 10 2, 3 9");
    	System.out.println("Minimum 4 ~ Maximum 10");
    	
    	BOARD_ROWS = s.nextInt();
    	BOARD_COLUMNS = s.nextInt();
    	while( !((BOARD_ROWS>=4) && (BOARD_ROWS <=10) &&
    			(BOARD_COLUMNS>=4) && (BOARD_COLUMNS <=10))){
    		System.out.println("Out of range. Try again.");
    		BOARD_ROWS = s.nextInt();
        	BOARD_COLUMNS = s.nextInt();
    	}
	}

	public static void setLives(int lives) {
		PLAYER_LIVES = lives;
	}
}
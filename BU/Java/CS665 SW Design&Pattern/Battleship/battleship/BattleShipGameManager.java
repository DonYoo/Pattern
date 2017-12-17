package battleship;

public class BattleShipGameManager {
    private Player[] players;

    /**
     * Instantiates a new Game.
     */
    public BattleShipGameManager() {
    	// setup the game board table
    	new Constants().setup();
    	
    	// create players
        players = new Player[]{
                new Player(1), new Player(2)	// Player id
        };
        players[0].setOpponent(players[1]);
        players[1].setOpponent(players[0]);
        
    }

    /**
     * Start.
     */
    public void start() {
        int i = 0;
        int size = players.length;
        Player player = null;

        // take turn to play.
        while(players[0].getLives() > 0 && players[1].getLives() > 0) {
        	i = i % size;
        	System.out.printf("player %d's turn\n", i+1);
            players[i++].Attack();
        }
        player = (players[0].getLives() < players[1].getLives()) ? players[1] : players[0];
        System.out.printf("Congrats Player %d, you won!",player.getId());
    }
}
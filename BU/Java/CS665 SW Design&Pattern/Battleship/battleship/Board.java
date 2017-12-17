package battleship;

import java.awt.Point;
import java.util.Scanner;

import Ship.*;

public class Board {
	private Ship[] ships;
	private char[][] board;
	private Scanner s;

	public Board() {    
		board = new char[Constants.BOARD_ROWS][Constants.BOARD_COLUMNS];

		for(int i = 0; i < Constants.BOARD_ROWS; i++) {
			for(int j = 0; j < Constants.BOARD_COLUMNS; j++) {
				board[i][j] = Constants.WATER_ICON;
			}
		}

		/**
		 * Initialize 3 different size of ships.
		 */

		ManufactureShip factory = new ManufactureShip();
		prepareShip store = new prepareShip(factory);

		ships = new Ship[]{
				store.orderShip("Ferry"),
				store.orderShip("Battleship"),
				store.orderShip("Submarine")
		};

		int lives = 0;
		for(Ship ship : ships){
			lives += ship.getSize();
		}
		Constants.setLives(lives);
		dispatch();
	}

	public void dispatch() {
		for(Ship ship : ships){

			System.out.println("\nPosition your ships\n");
			s = new Scanner(System.in);

			boolean isShipPositionLegal = false;

			System.out.println("\nEnter position of " + ship.getName() + 
					" (length  "+ship.getSize()+"). ex) x y coordinate");

			while(!isShipPositionLegal) {
				try {
					System.out.println("Ships head position x y");
					Point from = new Point(s.nextInt(), s.nextInt());
					System.out.println("Ships tail position x y");
					Point to = new Point(s.nextInt(), s.nextInt());

					while(ship.getSize() != Distance.distanceBetweenPoints(from, to)) {
						System.out.println("The ship currently being placed on the board is of length: "
								+ship.getSize()+". Change your coordinates and try again");

						System.out.println("Ships head position x y");
						from = new Point(s.nextInt(), s.nextInt());
						System.out.println("Ships tail position x y");
						to = new Point(s.nextInt(), s.nextInt());
					}
					Position position = new Position(from, to);

					if(!isPositionOccupied(position)) {
						drawShipOnBoard(position);
						ship.setPosition(position);
						isShipPositionLegal = true;
					} else {
						System.out.println("A ship in that position already exists - try again");
					}

				} catch(IndexOutOfBoundsException e) {
					System.out.println("Invalid coordinates - Outside board");
				}
			}
		}
	}

	private boolean isPositionOccupied(Position position) {
		boolean isOccupied = false;
		Point from = position.getFrom();
		Point to = position.getTo();

		outer:
			for(int i = (int) from.getY() - 1; i < to.getY(); i++) {
				for(int j = (int) from.getX() - 1; j < to.getX(); j++) {
					if(board[j][i] == Constants.SHIP_ICON) {
						isOccupied = true;
						break outer;
					}
				}
			}
		return isOccupied;
	}

	private void drawShipOnBoard(Position position) {
		Point from = position.getFrom();
		Point to = position.getTo();
		for(int i = (int) from.getX() - 1; i < to.getX(); i++) {
			for(int j = (int) from.getY() - 1; j < to.getY(); j++) {
				board[i][j] = Constants.SHIP_ICON;
			}
		}
		printBoard();
	}

	/**
	 * Target ship ship.
	 */
	public Ship targetShip(Point point) {
		boolean isHit = false;
		Ship hitShip = null;

		for(int i = 0; i < ships.length; i++) {
			Ship ship = ships[i];
			if(ship.getPosition() != null) {
				if(Distance.isPointBetween(point, ship.getPosition())) {
					isHit = true;
					hitShip = ship;
					break;
				}
			}
		}
		char result = isHit ? Constants.SHIP_IS_HIT_ICON : Constants.SHOT_NOTHING_ICON;
		updateShipOnBoard(point, result);
		printBoard();

		return (isHit) ? hitShip : null;
	}

	private void updateShipOnBoard(Point point, final char result) {
		int x = (int) point.getX() - 1;
		int y = (int) point.getY() - 1;
		board[x][y] = result;
	}

	/**
	 * Print board.
	 */
	private void printBoard() {
		System.out.print("\t");

		// ABCDE
		for(int i = 0; i < Constants.BOARD_ROWS; i++) {
			System.out.print(Constants.BOARD_LETTERS[i] + "\t");
		}
		System.out.println();

		for(int i = 0; i < Constants.BOARD_ROWS; i++) {
			System.out.print((i+1) + "\t");
			for(int j = 0; j < Constants.BOARD_COLUMNS; j++) {
				System.out.print(board[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
	}
}
package battleship;

import java.awt.Point;

public class Position {
    private Point from;
    private Point to;

    /**
     * Instantiates a new Position.
     */
    public Position(Point from, Point to) {
        if(from.getX() > Constants.BOARD_ROWS || from.getX() < 0
                || from.getY() > Constants.BOARD_COLUMNS || from.getY() < 0
                || to.getX() > Constants.BOARD_ROWS || to.getX() < 0
                || to.getY() > Constants.BOARD_COLUMNS || to.getY() < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        this.from = from;
        this.to = to;
    }

    /**
     * Gets from.
     */
    public Point getFrom() {
        return from;
    }

    /**
     * Gets to.
     */
    public Point getTo() {
        return to;
    }
}
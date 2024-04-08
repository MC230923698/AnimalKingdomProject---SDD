import java.awt.*;

// inherit from critter
public class Giant extends Critter {
    //private variables, only can use within this class
    private int moves; // keep track the number of move
    private int count; // to check which string to use

    // initiliased the value as 0 for starting
    public Giant() {
        moves = 0;
        count = 0;
    }

    // overwrite from super class
    public Action getMove(CritterInfo info) {
        moves++; // plus the number of moves
        count = (moves / 6) % 4; // calculate to change string to display

        // if infront got sometihng then infect the critter
        if (info.frontThreat()) {
            return Action.INFECT; 

        // if nothing then move forward
        } else if (info.getFront() == Neighbor.EMPTY) {
            return Action.HOP;

        // else, turn right
        } else {
            return Action.RIGHT;
        }
    }

    // overwrite method, to set giant as gray color
    public Color getColor() {
        return Color.GRAY;
    }

    // to change the appearance of giant, based on count
    public String toString() {
        switch (count) {
            case 0:
                return "fee";
            case 1:
                return "fie";
            case 2:
                return "foe";
            case 3:
                return "fum";
            default:
                return "fee"; // Default string to prevent compilation error
        }
    }
}

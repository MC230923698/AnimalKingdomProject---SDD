import java.awt.*;

// inherit from Critter
public class Bear extends Critter {
    // private variables, only allow to use within this class
    private boolean polar; // to check is polar or not
    private boolean isSlash; // to change 2 different characters - to display

    // initialise the value of polar and isSlash = true
    public Bear(boolean polar) {
        this.polar = polar;
        this.isSlash = true;
    }

    // Overwrite from main class, use inferface as object to pass parameter
    public Action getMove(CritterInfo info) {
        //if infront got something then infect that critter
        if (info.frontThreat()) { 
            return Action.INFECT;

        // if infront is empty then jump forward
        } else if (info.getFront() == Neighbor.EMPTY) { 
            return Action.HOP;

        // else, turn left
        } else {
            return Action.LEFT;
        }
    }
    // Overwrite from main class to determine the color of bear
    public Color getColor() {
        // if is polar then return white
        if (polar) {
            return Color.WHITE;
        
        // else, return black
        } else {
            return Color.BLACK;
        }
    }

    // Overwrite from main class, to change the appearance of bear
    public String toString() {
        if (isSlash) {
            isSlash = false;
            return "/";
        } else {
            isSlash = true;
            return "\\";
        }
    }
}

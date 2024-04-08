import java.awt.*;

// inherit from tiger, shared most of the method
public class WhiteTiger extends Tiger {
    private boolean infected; // to keep track infect or not

    // to initialised the starting value as false/no infected
    public WhiteTiger() {
        super();
        infected = false;
    }

    // inherit from tiger
    public Action getMove(CritterInfo info) {
        if (info.frontThreat()) {
            infect();
            return Action.INFECT;

        // if is a wall infront or right side, then turn left
        } else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL) {
            return Action.LEFT;

        // if is same type, then turn right
        } else if (info.getFront() == Neighbor.SAME) {
            return Action.RIGHT;

        // if not, move forward
        } else {
            return Action.HOP;
        }
    }

    // overwrite the method, change to white if infected
    public Color getColor() {
        return Color.WHITE;
       
    }

    // overwrite method, return lower case if is a white tiger
    public String toString() {
        if (infected) {
            return "TGR";
        } else {
            return "tgr";
        }
    }

    // special method, to indicate the white tiger infected
    public void infect() {
        infected = true;
    }
}

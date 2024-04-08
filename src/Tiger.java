import java.awt.*;

// inherit from Critter class
public class Tiger extends Critter {
    private Color color; // to set color for tiger
    private int moveCount; // to calculate number of move

    // initialise value for starting
    public Tiger() {
        setColor();
        moveCount = 0;
    }

    // private method, to change color based on random feature
    private void setColor() {
        int colorIndex = (int) (Math.random() * 3);
        switch (colorIndex) {
            case 0:
                color = Color.RED;
                break;
            case 1:
                color = Color.GREEN;
                break;
            case 2:
                color = Color.BLUE;
                break;
        }
    }

    @Override
    public Action getMove(CritterInfo info) {
        moveCount++;
        // if infront got something, then infect it
        if (info.frontThreat()) {
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

    // to set color for tiger
    @Override
    public Color getColor() {
        if (moveCount % 3 == 0) {
            setColor();
        }
        return color;
    }

    // to set appearance for tiger
    @Override
    public String toString() {
        return "TGR";
    }
}
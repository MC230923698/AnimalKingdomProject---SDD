import java.awt.*;

// inherit from critter
public class NinjaCat extends Critter {
    private Color color; // private variable for color, only allow to use within the class

    public NinjaCat() {
        // set ninjacat as orange
        this.color = Color.ORANGE;
    }

    @Override
    public Action getMove(CritterInfo info) {
        // use random feature to decide the movement
        int randomAction = (int) (Math.random() * 4);
        switch (randomAction) {
            case 0:
                return Action.HOP;
            case 1:
                return Action.LEFT;
            case 2:
                return Action.RIGHT;
            default:
                return Action.INFECT;
        }
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "N"; // set N for ninja cat appearance
    }
}
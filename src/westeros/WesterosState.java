package westeros;

import generic.State;
import utils.Pair;
import java.util.TreeSet;

public class WesterosState extends State {

    private Pair position;
    private int dragonGlass;
    private TreeSet<Pair> whiteWalkersPositions;

    public WesterosState(Pair position, int dragonGlass, TreeSet<Pair> whiteWalkersPositions) {
        this.position = position;
        this.dragonGlass = dragonGlass;
        this.whiteWalkersPositions = (TreeSet<Pair>) whiteWalkersPositions.clone();
    }

    public Pair getPosition() {
        return position;
    }

    public int getDragonGlass() {
        return dragonGlass;
    }

    public TreeSet<Pair> getWhiteWalkersPositions() {
        return whiteWalkersPositions;
    }

    public void setPosition(Pair position) {
        this.position = position;
    }

    public void setDragonGlass(int dragonGlass) {
        this.dragonGlass = dragonGlass;
    }

    public void setWhiteWalkersPositions(TreeSet<Pair> whiteWalkersPositions) {
        this.whiteWalkersPositions = whiteWalkersPositions;
    }
}

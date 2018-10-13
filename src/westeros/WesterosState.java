package westeros;

import generic.State;
import utils.Pair;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * State for the SaveWesteros Problem.
 */

public class WesterosState extends State {

    private Pair position;
    private int dragonGlass;
    private int maxDragonGlass;
    private TreeSet<Pair> whiteWalkersPositions;

    public WesterosState(Pair position, int dragonGlass, int maxDragonGlass, TreeSet<Pair> whiteWalkersPositions) {
        this.position = position;
        this.dragonGlass = dragonGlass;
        this.maxDragonGlass = maxDragonGlass;
        this.whiteWalkersPositions = (TreeSet<Pair>) whiteWalkersPositions.clone();
    }

    public Pair getPosition() {
        return position;
    }

    public int getDragonGlass() {
        return dragonGlass;
    }

    public int getMaxDragonGlass() {
        return maxDragonGlass;
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

    @Override
    public String toString() {
        return "WesterosState{" +
                "position=" + position +
                ", dragonGlass=" + dragonGlass +
//                ", wwCount=" + whiteWalkersPositions+
                '}';
    }

    @Override
    public int compareTo(State o) {
        WesterosState oo = ((WesterosState) o);
        if (oo.position.compareTo(this.position) == 0) {
            if (oo.dragonGlass == this.dragonGlass) {
                Iterator<Pair> i = this.whiteWalkersPositions.iterator();
                Iterator<Pair> j = oo.whiteWalkersPositions.iterator();
                while (i.hasNext() && j.hasNext()) {
                    Pair a = i.next();
                    Pair b = j.next();
                    if (a.compareTo(b) != 0)
                        return a.compareTo(b);
                }
                if (i.hasNext())
                    return 1;

                if (j.hasNext())
                    return -1;

                return 0;
            }
            return this.dragonGlass - oo.dragonGlass;
        }
        return this.position.compareTo(oo.position);
    }
}

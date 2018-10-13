package westeros.heuristics;

import generic.Node;
import utils.Pair;
import westeros.WesterosMap;
import westeros.WesterosState;

/**
 * Heuristic function using the number of pickups needed.
 */

public class PickupHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        WesterosState state = (WesterosState) node.getState();
        int numberOfWhiteWalkers = state.getWhiteWalkersPositions().size();
        int minWWtoKill = (int) Math.ceil(numberOfWhiteWalkers / 3.0);
        int result  = (int) Math.ceil((minWWtoKill - state.getDragonGlass()) / (1.0 * state.getMaxDragonGlass()));
        return Math.max(0, result);
    }
}

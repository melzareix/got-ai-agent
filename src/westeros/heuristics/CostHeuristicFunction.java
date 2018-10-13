package westeros.heuristics;

import generic.Node;
import westeros.WesterosMap;
import westeros.WesterosState;

/**
 * Heuristic function using the cost to kill the remaining white walkers.
 */
public class CostHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        WesterosState state = (WesterosState) node.getState();
        int numberOfWhiteWalkers = state.getWhiteWalkersPositions().size();
        WesterosMap map = WesterosMap.getInstance();
        int costToKill = 3 * (map.m + map.n);
        return (int) (Math.ceil(numberOfWhiteWalkers / 3.0) * costToKill);
    }
}

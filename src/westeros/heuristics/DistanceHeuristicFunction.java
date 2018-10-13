package westeros.heuristics;

import generic.Node;
import utils.Pair;
import westeros.WesterosState;

/**
 * Heuristic function using the distance to the farthest white walker.
 */

public class DistanceHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        WesterosState state = (WesterosState) node.getState();
        int maxDistance = 0;
        for (Pair ww : state.getWhiteWalkersPositions()) {
            int manDistance = Math.abs(ww.x - state.getPosition().x) +  Math.abs(ww.y - state.getPosition().y) - 1;
            maxDistance = Math.max(maxDistance, manDistance);
        }
        return maxDistance;
    }
}

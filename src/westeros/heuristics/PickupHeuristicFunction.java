package westeros.heuristics;

import generic.Node;
import utils.Pair;
import westeros.WesterosState;

public class PickupHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        WesterosState state = (WesterosState) node.getState();
//        int numberOfWhiteWalkers = state.getWhiteWalkersPositions().size();
//        int minWWtoKill = (int) Math.ceil(numberOfWhiteWalkers / 3.0);
//        int result  = (int) Math.ceil((minWWtoKill - state.getDragonGlass()) / (1.0 * state.getMaxDragonGlass()));
//        return Math.max(0, result);
        int maxDistance = 0;
        for (Pair ww : state.getWhiteWalkersPositions()) {
            int manDistance = Math.abs(ww.x - state.getPosition().x) +  Math.abs(ww.y - state.getPosition().y) - 1;
            maxDistance = Math.max(maxDistance, manDistance);
        }
        return maxDistance;
    }
}

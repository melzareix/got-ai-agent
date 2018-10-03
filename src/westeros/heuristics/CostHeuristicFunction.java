package westeros.heuristics;

import generic.Node;
import utils.Pair;
import westeros.WesterosMap;
import westeros.WesterosState;

public class CostHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        WesterosState state = (WesterosState) node.getState();
        int numberOfWhiteWalkers = state.getWhiteWalkersPositions().size();
        WesterosMap map = WesterosMap.getInstance();
        int costToKill = 3 * (map.m + map.n);
        int minWWtoKill = (int) (Math.ceil(numberOfWhiteWalkers / 3.0) * costToKill);

//        int maxDistance = 0;
//        for (Pair ww : state.getWhiteWalkersPositions()) {
//            int manDistance = Math.abs(ww.x - state.getPosition().x) +  Math.abs(ww.y - state.getPosition().y) - 1;
//            maxDistance = Math.max(maxDistance, manDistance);
//        }
        return minWWtoKill;
    }
}

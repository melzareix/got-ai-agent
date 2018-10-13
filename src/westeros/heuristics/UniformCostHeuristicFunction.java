package westeros.heuristics;

import generic.Node;

/**
 * Cost function for uniform cost strategy.
 */
public class UniformCostHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        return node.getCost();
    }
}

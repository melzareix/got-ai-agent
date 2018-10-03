package westeros.heuristics;

import generic.Node;

public class UniformCostHeuristicFunction extends BaseHeuristicFunction {
    @Override
    public int applyHeuristic(Node node) {
        return node.getCost();
    }
}

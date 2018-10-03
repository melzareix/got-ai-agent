package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

public class UniformCostEvaluator extends BaseEvaluator {
    public UniformCostEvaluator() {
        super(null);
    }

    @Override
    public int apply(Node node) {
        return node.getCost();
    }
}

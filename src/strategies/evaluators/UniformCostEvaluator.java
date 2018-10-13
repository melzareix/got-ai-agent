package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

/**
 * Evaluator for Uniform-cost searching strategy cost.
 */
public class UniformCostEvaluator extends BaseEvaluator {
    public UniformCostEvaluator() {
        super(null);
    }

    @Override
    public int apply(Node node) {
        return node.getCost();
    }
}

package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

public class GreedyEvaluator extends BaseEvaluator {
    public GreedyEvaluator(BaseHeuristicFunction heuristicFunction) {
        super(heuristicFunction);
    }

    @Override
    public int apply(Node node) {
        return heuristicFunction.applyHeuristic(node);
    }
}

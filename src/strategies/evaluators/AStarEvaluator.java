package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

/**
 * Evaluator for AStar searching strategy cost.
 */
public class AStarEvaluator extends BaseEvaluator {
    public AStarEvaluator(BaseHeuristicFunction heuristicFunction) {
        super(heuristicFunction);
    }

    @Override
    public int apply(Node node) {
        return this.heuristicFunction.applyHeuristic(node) + node.getCost();
    }
}

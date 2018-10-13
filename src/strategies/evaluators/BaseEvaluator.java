package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

/**
 * Base Class for Evaluator function for search strategy.
 */
public abstract class BaseEvaluator {
    BaseHeuristicFunction heuristicFunction;

    BaseEvaluator(BaseHeuristicFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    public abstract int apply(Node node);
}

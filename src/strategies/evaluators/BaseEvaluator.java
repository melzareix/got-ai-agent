package strategies.evaluators;

import generic.Node;
import westeros.heuristics.BaseHeuristicFunction;

public abstract class BaseEvaluator {
    protected BaseHeuristicFunction heuristicFunction;

    public BaseEvaluator(BaseHeuristicFunction heuristicFunction) {
        this.heuristicFunction = heuristicFunction;
    }

    public abstract int apply(Node node);

    public BaseHeuristicFunction getHeuristicFunction() {
        return heuristicFunction;
    }
}

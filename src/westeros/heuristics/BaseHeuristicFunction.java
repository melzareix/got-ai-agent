package westeros.heuristics;

import generic.Node;

/**
 * Base Class for a heuristic function.
 */
public abstract class BaseHeuristicFunction {
    public abstract int applyHeuristic(Node node);

    @Override
    public String toString() {
        return this.getClass().toString();
    }
}

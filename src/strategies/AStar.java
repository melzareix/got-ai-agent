package strategies;

import generic.State;
import strategies.comparators.NodeComparator;
import strategies.evaluators.AStarEvaluator;
import westeros.heuristics.BaseHeuristicFunction;

import java.util.PriorityQueue;

public class AStar extends UniformCost {
    public AStar(State initialState, BaseHeuristicFunction heuristicFunction) {
        super(initialState);
        this.evaluator = new AStarEvaluator(heuristicFunction);
        this.comparator = new NodeComparator(evaluator);
        resetQueue();
    }

    @Override
    void initQueue() {
        queue = new PriorityQueue<>(this.comparator);
    }
}

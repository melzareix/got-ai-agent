package strategies;

import generic.State;
import strategies.comparators.NodeComparator;
import strategies.evaluators.GreedyEvaluator;
import westeros.heuristics.BaseHeuristicFunction;

import java.util.PriorityQueue;

/*
 * Implementing Greedy strategy.
 */
public class Greedy extends UniformCost {
    public Greedy(State initialState, BaseHeuristicFunction heuristicFunction) {
        super(initialState);
        this.evaluator = new GreedyEvaluator(heuristicFunction);
        this.comparator = new NodeComparator(evaluator);
        resetQueue();
    }

    @Override
    void initQueue() {
        queue = new PriorityQueue<>(this.comparator);
    }
}

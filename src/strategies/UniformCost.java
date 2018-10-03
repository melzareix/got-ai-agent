package strategies;

import generic.Node;
import generic.State;
import strategies.comparators.NodeComparator;
import strategies.evaluators.BaseEvaluator;
import strategies.evaluators.GreedyEvaluator;
import strategies.evaluators.UniformCostEvaluator;
import westeros.heuristics.BaseHeuristicFunction;
import westeros.heuristics.PickupHeuristicFunction;

import java.util.PriorityQueue;

public class UniformCost extends SearchQueue {
    protected PriorityQueue<Node> queue;
    public NodeComparator comparator;
    protected BaseEvaluator evaluator;

    public UniformCost(State initialState) {
        super(initialState);
    }

    @Override
    void initQueue() {
        this.evaluator = new UniformCostEvaluator();
        queue = new PriorityQueue<>(this.comparator = new NodeComparator(evaluator));
    }

    @Override
    public Node removeFront() {
        Node curr = queue.poll();
        if (curr == null) return null;
        int currNodeCost = comparator.getNodeCost(curr);
        if (previousStates.containsKey(curr.getState())) {
            int prevNodeCost = previousStates.get(curr.getState());
            if (currNodeCost >= prevNodeCost) return null;
        }
        previousStates.put(curr.getState(), currNodeCost);
        return curr;
    }

    @Override
    public void enqueue(Node node) {
        queue.add(node);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

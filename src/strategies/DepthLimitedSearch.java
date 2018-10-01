package strategies;

import generic.Node;
import generic.State;

import java.util.Stack;

public class DepthLimitedSearch extends SearchQueue {
    private Stack<Node> queue;
    public int depth;

    public DepthLimitedSearch(State initialState, int depth) {
        super(initialState);
        this.depth = depth;
    }

    @Override
    void initQueue() {
        queue = new Stack<>();
    }

    @Override
    public Node removeFront() {
        if(isEmpty()) {
            return null;
        }
        Node n = queue.pop();

        boolean exploredBefore = previousStates.containsKey(n.getState()) && previousStates.get(n.getState()) <= n.getDepth();
        boolean depthCrossed = n.getDepth() > this.depth;
        if (exploredBefore || depthCrossed) return null;

        previousStates.put(n.getState(), n.getDepth());
        return n;
    }

    @Override
    public void enqueue(Node node) {
        queue.push(node);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}

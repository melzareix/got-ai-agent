package strategies;

import generic.Node;
import generic.State;

import java.util.Stack;

/**
 * Implementing DFS strategy.
 */
public class DepthFirst extends SearchQueue {
    private Stack<Node> queue;

    public DepthFirst(State initialState) {
        super(initialState);
    }

    @Override
    void initQueue() {
        queue = new Stack<>();
    }

    @Override
    public Node removeFront() {
        if (isEmpty()) return null;
        Node n = queue.pop();
        if (previousStates.containsKey(n.getState())) return null;
        previousStates.put(n.getState(), 0);
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

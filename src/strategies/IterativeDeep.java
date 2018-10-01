package strategies;

import generic.Node;
import generic.State;

public class IterativeDeep extends SearchQueue {
    DepthLimitedSearch queue;
    public IterativeDeep(State initialState) {
        super(initialState);
    }

    @Override
    void initQueue() {
        queue = new DepthLimitedSearch(this.initialState, 0);
    }

    @Override
    public Node removeFront() {
        return queue.removeFront();
    }

    @Override
    public void enqueue(Node node) {
        queue.enqueue(node);
    }

    @Override
    public boolean isEmpty() {
        boolean isDone = queue.isEmpty();
        if (isDone) {
            System.out.println("NO SOLUTION @ "  + queue.depth);
            queue.depth++;
            queue.resetQueue();
        }
        return false;
    }
}

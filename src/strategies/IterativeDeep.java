package strategies;

import generic.Node;
import generic.State;

/*
 * Implementing Iterative Deepening strategy.
 */

public class IterativeDeep extends SearchQueue {
    private DepthLimitedSearch queue;

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
            System.out.printf("Tried depth %d but failed to find solution, trying depth %d ...\n",
                    queue.depth, queue.depth + 1);
            queue.depth++;
            queue.resetQueue();
        }
        return false;
    }
}

package strategies;

import generic.Node;
import generic.State;

import java.util.LinkedList;
import java.util.Queue;

/*
* Implementing BFS strategy.
*/

public class BreadthFirst extends SearchQueue {
    private Queue<Node> queue;

    public BreadthFirst(State initialState) {
        super(initialState);
    }

    @Override
    void initQueue() {
        queue = new LinkedList<>();
    }


    @Override
    public void enqueue(Node node) {
        queue.add(node);
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public Node removeFront() {
        Node n = queue.poll();
        if (previousStates.containsKey(n.getState())) return null;
        previousStates.put(n.getState(), 0);
        return n;
    }
}

package strategies;

import generic.Node;
import generic.State;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Base Class for a search queue.
 */

public abstract class SearchQueue {
    TreeMap<State, Integer> previousStates;
    State initialState;

    SearchQueue(State initialState) {
        this.initialState = initialState;
        resetQueue();
    }

    void resetQueue() {
        this.previousStates = new TreeMap<>();
        Node initialNode = new Node(this.initialState, null, null);
        initQueue();
        enqueue(initialNode);
    }

    abstract void initQueue();

    public abstract Node removeFront();

    public abstract void enqueue(Node node);

    public abstract boolean isEmpty();

    public void enqueue(ArrayList<Node> nodes) {
        for (Node node : nodes) {
            enqueue(node);
        }
    }

    @Override
    public String toString() {
        return "SearchQueue{" +
                "previousStates=" + previousStates +
                ", initialState=" + initialState +
                '}';
    }
}

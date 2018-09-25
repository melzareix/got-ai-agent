package generic;

import java.util.ArrayList;

abstract public class SearchProblem {
    public State initialState;

    public abstract State setInitialState();
    public abstract Object makeQueue(Object prevQueue, ArrayList<Node> nodes, String strategy);
    public abstract Node makeNode(State state);
    public abstract ArrayList<Node> expand(Node n, Operator[] o);
    public abstract boolean goalTest(State state);
}

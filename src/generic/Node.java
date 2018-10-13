package generic;

/**
 * Generic Node class.
 */
public class Node {
    private State state;
    private Node parent;
    private Operator operator;
    private int depth;
    private int cost;

    public Node(State state, Node parent, Operator operator) {
        this.state = state;
        this.parent = parent;
        this.operator = operator;

        if (this.parent != null) {
            this.depth = parent.getDepth() + 1;
            this.cost = parent.getCost() + operator.getCost();
        }
    }

    /**
     * @return the state of the node.
     */
    public State getState() {
        return state;
    }

    /**
     * @return the parent of the node.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @return the operator applied to get the node.
     */
    public Operator getOperator() {
        return operator;
    }

    /**
     * set the cost of the node.
     * @param cost the new cost of the node.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * @return depth of the node in the tree.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @return cost of the path of the node.
     */
    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", operator=" + operator +
                ", parent=" + parent +
                ", cost=" + cost +
                '}';
    }
}

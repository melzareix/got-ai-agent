package generic;

public class Node {
    private State state;
    private Node parent;
    private Operator operator;
    private int depth;
    private int cost;

    public Node(State state, Node parent, Operator operator, int depth, int cost) {
        this.state = state;
        this.parent = parent;

        this.operator = operator;
        this.depth = depth;
        this.cost = cost;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

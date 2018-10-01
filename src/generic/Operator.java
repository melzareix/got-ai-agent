package generic;

public abstract class Operator {
    private int cost;
    private String name;

    /**
     * Create a new operator name and cost.
     *
     * @param cost the cost of the operator.
     * @param name the name of the operator.
     */
    public Operator(int cost, String name) {
        this.cost = cost;
        this.name = name;
    }

    /**
     * Apply the operator to a node.
     * @param node the node to apply the operator to.
     * @return a new node with operator cost applied.
     */
    public abstract Node apply(Node node);

    /**
     *
     * @return the cost of the operator.
     */
    public int getCost() {
        return cost;
    }

    /**
     * @return the name of the operator.
     */
    public String getName() {
        return name;
    }
}
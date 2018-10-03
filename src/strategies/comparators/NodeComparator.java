package strategies.comparators;

import generic.Node;
import strategies.evaluators.BaseEvaluator;

import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    public BaseEvaluator evaluator;

    public NodeComparator(BaseEvaluator evaluator) {
        this.evaluator = evaluator;
    }

    public int getNodeCost(Node node) {
        return evaluator.apply(node);
    }


    @Override
    public int compare(Node o1, Node o2) {
        return evaluator.apply(o1) - evaluator.apply(o2);
    }

    public BaseEvaluator getEvaluator() {
        return evaluator;
    }
}

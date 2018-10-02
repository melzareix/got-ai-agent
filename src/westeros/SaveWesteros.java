package westeros;

import generic.*;
import utils.Pair;
import westeros.operators.KillOperator;
import westeros.operators.PickupOperator;
import westeros.operators.movement.MoveDownOperator;
import westeros.operators.movement.MoveLeftOperator;
import westeros.operators.movement.MoveRightOperator;
import westeros.operators.movement.MoveUpOperator;

import java.util.*;

public class SaveWesteros extends SearchProblem {
    private WesterosMap map;

    public SaveWesteros() {
        this.map = WesterosMap.getInstance();
        this.addOperators();
    }

    @Override
    public State getInitialState() {
        Pair initialPosition = new Pair(map.m - 1, map.n - 1);
        return new WesterosState(initialPosition, 0, map.maxGlass, map.getWhiteWalkersPositions());
    }

    @Override
    public ArrayList<Node> expand(Node n, ArrayList<Operator> operators) {
        ArrayList<Node> nodes = new ArrayList<>();
        for (Operator o : operators) {
            Node newNode = o.apply(n);
            if (newNode != null) {
                nodes.add(newNode);
            }
        }
        return nodes;
    }

    public void printMap() {
        System.out.println("======================");
        System.out.println("Initial Westeros Map");
        System.out.println("======================");
        this.map.printGrid();
        System.out.println("======================");
    }

    @Override
    public boolean goalTest(State state) {
        return ((WesterosState) state).getWhiteWalkersPositions().isEmpty();
    }

    @Override
    public void printSolution(Node node, boolean visualize, int totalNodes) {
        Solution solution = new Solution(visualize, totalNodes);

        // Add solution nodes to the solution
        while (node.getParent() != null) {
            solution.addNode(node);
            node = node.getParent();
        }
        solution.addNode(node);
        solution.printSolution();

    }

    private void addOperators() {
        this.operators = new ArrayList<>();
        operators.add(new MoveUpOperator());
        operators.add(new MoveDownOperator());
        operators.add(new MoveLeftOperator());
        operators.add(new MoveRightOperator());
        operators.add(new PickupOperator());
        operators.add(new KillOperator(3 * (this.map.m + this.map.n)));
    }
}



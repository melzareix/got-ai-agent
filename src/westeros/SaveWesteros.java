package westeros;

import generic.Node;
import generic.Operator;
import generic.SearchProblem;
import generic.State;
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
        for (Operator o: operators) {
            Node newNode = o.apply(n);
            if (newNode != null) {
                nodes.add(newNode);
            }
        }
        return nodes;
    }

    public void printMap() {
        this.map.printGrid();
    }

    @Override
    public boolean goalTest(State state) {
        return ((WesterosState) state).getWhiteWalkersPositions().isEmpty();
    }

    @Override
    public void printSolution(Node node) {
        if (node.getParent() != null) {
            System.out.println(node);
            printSolution(node.getParent());
        }
    }

    private void addOperators() {
        this.operators = new ArrayList<>();
        operators.add(new MoveUpOperator());
        operators.add(new MoveDownOperator());
        operators.add(new MoveLeftOperator());
        operators.add(new MoveRightOperator());
        operators.add(new PickupOperator());
        operators.add(new KillOperator());
    }
}



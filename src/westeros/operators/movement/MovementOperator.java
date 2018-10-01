package westeros.operators.movement;

import generic.Node;
import utils.Pair;
import utils.Cell;
import westeros.WesterosState;
import westeros.operators.WesterosOperator;

public class MovementOperator extends WesterosOperator {
    Pair newValues;
    public MovementOperator(int cost, String name, Pair values) {
        super(cost, name);
        this.newValues = values;
    }

    @Override
    public Node apply(Node node) {
        WesterosState currentState = (WesterosState) node.getState();
        Cell newPosition = new Cell(currentState.getPosition().x + newValues.x, currentState.getPosition().y + newValues.y);
        if (!isValidMove(newPosition, currentState)) return null;

        WesterosState nextState = new WesterosState(newPosition,
                currentState.getDragonGlass(),
                currentState.getMaxDragonGlass(),
                currentState.getWhiteWalkersPositions());

        // same state as parent
        if (node.getParent() != null && nextState.compareTo(node.getParent().getState()) == 0) {
            return null;
        }
        return new Node(nextState, node, this);
    }
}

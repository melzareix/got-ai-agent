package westeros.operators;

import generic.Node;
import generic.Operator;
import utils.Cell;
import utils.Pair;
import westeros.WesterosMap;
import westeros.WesterosState;

public abstract class WesterosOperator extends Operator {
    /**
     * Create a new operator name and cost.
     *
     * @param cost the cost of the operator.
     * @param name the name of the operator.
     */
    public WesterosMap map;
    public WesterosOperator(int cost, String name) {
        super(cost, name);
        this.map = WesterosMap.getInstance();
    }

    public boolean isValidMove(Cell position, WesterosState state) {
        boolean validPosition =  position.isValid(map.m, map.n);
        if (!validPosition) return false;

        boolean isObstacle = this.map.isObstacle(position);
        boolean isWhiteWalker = hasWhiteWalker(position, state);
        return  !isObstacle && !isWhiteWalker;
    }

    public boolean hasWhiteWalker(Cell position, WesterosState state) {
        return state.getWhiteWalkersPositions().contains(position);
    }
}

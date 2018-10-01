package westeros.operators;

import generic.Node;
import utils.Cell;
import westeros.WesterosState;

public class PickupOperator extends WesterosOperator {
    public PickupOperator() {
        super(0, "PICKUP");
    }

    @Override
    public Node apply(Node node) {
        WesterosState currentState = (WesterosState) node.getState();
        if (!canPickupGlass(currentState)) return null;
        WesterosState nextState = new WesterosState(currentState.getPosition(),
                currentState.getMaxDragonGlass(),
                currentState.getMaxDragonGlass(),
                currentState.getWhiteWalkersPositions());

        return new Node(nextState, node, this);
    }

    private boolean canPickupGlass(WesterosState state) {
        boolean isDragonGlass = this.map.isDragonGlass(state.getPosition());
        boolean needToRecharge = state.getDragonGlass() != state.getMaxDragonGlass();
        return isDragonGlass && needToRecharge;
    }
}

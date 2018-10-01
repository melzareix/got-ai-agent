package westeros.operators;

import generic.Node;
import utils.Pair;
import westeros.WesterosState;

import java.util.TreeSet;

public class KillOperator extends WesterosOperator {
    public KillOperator() {
        super(1, "KILL");
    }

    @Override
    public Node apply(Node node) {
        WesterosState currentState = (WesterosState) node.getState();
        Pair[] adjacentCells = genAdjacentCells(currentState.getPosition());
        if (!canKillWhiteWalker(currentState, adjacentCells)) return null;

        TreeSet<Pair> whiteWalkersPositions = (TreeSet<Pair>) currentState.getWhiteWalkersPositions().clone();
        for (int i = 0; i < adjacentCells.length; i++) {
            whiteWalkersPositions.remove(adjacentCells[i]);
        }
        WesterosState nextState = new WesterosState(currentState.getPosition(),
                currentState.getDragonGlass() - 1,
                currentState.getMaxDragonGlass(),
                whiteWalkersPositions);
        return new Node(nextState, node, this);
    }

    private Pair[] genAdjacentCells(Pair p) {
        int x = p.getX(), y = p.getY();
        Pair[] cells = new Pair[4];
        cells[0] = new Pair(x - 1, y);
        cells[1] = new Pair(x + 1, y);
        cells[2] = new Pair(x, y - 1);
        cells[3] = new Pair(x, y + 1);
        return cells;
    }

    private boolean canKillWhiteWalker(WesterosState state, Pair[] adjacentCells) {
        if (state.getDragonGlass() == 0) return false;
        TreeSet<Pair> whiteWalkersPositions = state.getWhiteWalkersPositions();

        boolean isWhiteWalkersAround = false;
        for (int i = 0; i < 4; i++) {
            isWhiteWalkersAround = isWhiteWalkersAround || whiteWalkersPositions.contains(adjacentCells[i]);
        }
        return isWhiteWalkersAround;
    }
}

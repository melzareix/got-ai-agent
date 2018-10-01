package westeros.operators.movement;

import utils.Pair;

public class MoveDownOperator extends MovementOperator {

    public MoveDownOperator() {
        super(1, "MOVE_DOWN", new Pair(1, 0));
    }
}

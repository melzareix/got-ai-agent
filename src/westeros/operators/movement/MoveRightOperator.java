package westeros.operators.movement;

import utils.Pair;

public class MoveRightOperator extends MovementOperator {

    public MoveRightOperator() {
        super(1, "MOVE_RIGHT", new Pair(0, 1));
    }
}

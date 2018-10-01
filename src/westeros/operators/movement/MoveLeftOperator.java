package westeros.operators.movement;

import utils.Pair;

public class MoveLeftOperator extends MovementOperator {

    public MoveLeftOperator() {
        super(1, "MOVE_LEFT", new Pair(0, -1));
    }
}

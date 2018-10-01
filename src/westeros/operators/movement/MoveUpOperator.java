package westeros.operators.movement;

import utils.Pair;

public class MoveUpOperator extends MovementOperator {

    public MoveUpOperator() {
        super(1, "MOVE_UP", new Pair(-1, 0));
    }
}

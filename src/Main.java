import strategies.BreadthFirst;
import strategies.DepthFirst;
import strategies.DepthLimitedSearch;
import strategies.IterativeDeep;
import westeros.SaveWesteros;
import westeros.WesterosState;
import westeros.operators.WesterosOperator;

public class Main {
    public static void main(String[] args) {
        SaveWesteros problem = new SaveWesteros();
        problem.printMap();

        problem.search(BreadthFirst.class, true);
        problem.search(DepthFirst.class, true);
//        problem.search(IterativeDeep.class, true);
    }
}

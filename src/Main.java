import strategies.*;
import westeros.SaveWesteros;
import westeros.heuristics.CostHeuristicFunction;
import westeros.heuristics.PickupHeuristicFunction;
import westeros.heuristics.UniformCostHeuristicFunction;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SaveWesteros problem = new SaveWesteros();
        problem.printMap();

//        problem.search(BreadthFirst.class, true);
        PickupHeuristicFunction pickupHeuristic = new PickupHeuristicFunction();
        CostHeuristicFunction costHeuristic = new CostHeuristicFunction();

        problem.search(BreadthFirst.class, null, false);
        problem.search(DepthFirst.class, null, false);
        problem.search(IterativeDeep.class, null, false);
        problem.search(UniformCost.class, null, false);
        problem.search(Greedy.class, pickupHeuristic, false);
        problem.search(Greedy.class, costHeuristic, false);
        problem.search(AStar.class, costHeuristic, false);
        problem.search(AStar.class, pickupHeuristic, false);
    }
}

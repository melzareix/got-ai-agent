import strategies.*;
import westeros.SaveWesteros;
import westeros.heuristics.CostHeuristicFunction;
import westeros.heuristics.DistanceHeuristicFunction;
import westeros.heuristics.PickupHeuristicFunction;
import westeros.heuristics.UniformCostHeuristicFunction;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SaveWesteros problem = new SaveWesteros();
        problem.printMap();

//        Heuristics
        PickupHeuristicFunction pickupHeuristic = new PickupHeuristicFunction();
        CostHeuristicFunction costHeuristic = new CostHeuristicFunction();
        DistanceHeuristicFunction distanceHeuristic = new DistanceHeuristicFunction();

//        Compare all algorithms
        problem.search(BreadthFirst.class, null, false);
        problem.search(DepthFirst.class, null, false);
        problem.search(IterativeDeep.class, null, false);

        problem.search(UniformCost.class, null, false);

        problem.search(Greedy.class, costHeuristic, false);
        problem.search(Greedy.class, pickupHeuristic, false);
        problem.search(Greedy.class, distanceHeuristic, false);

        problem.search(AStar.class, costHeuristic, false);
        problem.search(AStar.class, pickupHeuristic, false);
        problem.search(AStar.class, distanceHeuristic, false);
    }
}

package generic;

import strategies.SearchQueue;
import westeros.heuristics.BaseHeuristicFunction;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

abstract public class SearchProblem {
    public ArrayList<Operator> operators;

    public abstract State getInitialState();

    public abstract ArrayList<Node> expand(Node n, ArrayList<Operator> o);

    /**
     * Checks whether the state is a goal state or not.
     *
     * @param state the state to be tested.
     * @return whether the state is a goal state or not.
     */
    public abstract boolean goalTest(State state);

    /**
     * @return the list of operators associated with the problem.
     */
    public ArrayList<Operator> getOperators() {
        return operators;
    }

    /**
     * @param queue the search strategy to use.
     * @param visualize a flag to print the final solution.
     */
    public void search(Class queue, BaseHeuristicFunction heuristic, boolean visualize) {
        // Use reflection to initialize class queue
        System.out.println(queue);
        try {
            SearchQueue searchQueue;
            if (heuristic == null) {
                Constructor<?> cons = queue.getConstructor(State.class);
                searchQueue = (SearchQueue) cons.newInstance(this.getInitialState());
            } else {
                Constructor<?> cons = queue.getConstructor(State.class, BaseHeuristicFunction.class);
                searchQueue = (SearchQueue) cons.newInstance(this.getInitialState(), heuristic);
            }
            int totalNodes = 0;
            while (!searchQueue.isEmpty()) {
                Node curr = searchQueue.removeFront();
                totalNodes++;
                if (curr == null) continue;

                if (goalTest(curr.getState())) {
                    printSolution(curr, visualize, totalNodes);
                    return;
                }
                ArrayList<Node> nodes = expand(curr, operators);
                searchQueue.enqueue(nodes);
            }
            System.out.println("NO SOLUTION FOUND");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public abstract void printSolution(Node node, boolean visualize, int totalNodes);
}

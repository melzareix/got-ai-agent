package generic;

import strategies.SearchQueue;
import westeros.heuristics.BaseHeuristicFunction;

import java.lang.reflect.Constructor;
import java.util.ArrayList;

/**
 * Generic Search Problem Class to be inherited
 * by all sub-problems.
 */
abstract public class SearchProblem {
    public ArrayList<Operator> operators;

    /**
     * Set the initial state of the problem.
     * @return the initial state.
     */
    public abstract State getInitialState();

    /**
     * State space simulator given a state and an operator return
     * the next state.
     * @param state initial state
     * @param o operator to apply
     * @return the next state
     */
    public abstract State getNextState(State state, Operator o);
    /**
     * Expands the node n by applying each operator in o to it.
     * @param n the node to expand
     * @param o list of operators to apply.
     * @return list of new nodes after applying each operator.
     */
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
     * General Search algorithm to solve search problems.
     * @param queue the search strategy to use.
     * @param visualize a flag to print the final solution.
     */
    public void search(Class queue, BaseHeuristicFunction heuristic, boolean visualize) {
        // Use old fashioned reflection to initialize class queue
        // passing functions??? this is java we don't do that here.
        System.out.println(queue + " " + (heuristic == null ? " " : " - " + heuristic));
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
            System.out.println("Winter has come and John snow couldn't stop the walkers!");
            System.out.println("======================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Print the solution starting from the goal node.
     * @param node the solution node
     * @param visualize boolean to print the grid or not
     * @param totalNodes the total number of visited nodes
     */
    public abstract void printSolution(Node node, boolean visualize, int totalNodes);
}

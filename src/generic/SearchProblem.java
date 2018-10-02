package generic;

import strategies.SearchQueue;
import westeros.WesterosState;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
    public void search(Class queue, boolean visualize) {
        // Use reflection to initialize class queue
        try {
            Constructor<?> cons = queue.getConstructor(State.class);
            SearchQueue searchQueue = (SearchQueue) cons.newInstance(this.getInitialState());
            while (!searchQueue.isEmpty()) {
                Node curr = searchQueue.removeFront();
                if (curr == null) continue;

                if (goalTest(curr.getState())) {
                    printSolution(curr, visualize);
                    return;
                }
                ArrayList<Node> nodes = expand(curr, operators);
                searchQueue.enqueue(nodes);
            }
            System.out.println("NO SOLUTION FOUND");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public abstract void printSolution(Node node, boolean visualize);
}

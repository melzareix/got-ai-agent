package westeros;

import generic.Node;
import generic.Solution;
import utils.Pair;
import westeros.operators.KillOperator;

import java.util.ArrayList;

public class WesterosSolution extends Solution {

    // set to false to print the whole sequence at once.
    private static boolean WAIT_FOR_NEXT = false;
    private ArrayList<char[][]> solutionSteps;
    private WesterosMap map;

    WesterosSolution(boolean visualize, int totalNodes) {
        super(visualize, totalNodes);
        solutionSteps = new ArrayList<>();
        map = WesterosMap.getInstance();
    }

    @Override
    public void printSolution() {
        for (Node node : solutionNodes) {
            depth = Math.max(depth, node.getDepth());
            if (node.getOperator() instanceof KillOperator) cost++;
            solutionOperators.add(node.getOperator());
            solutionSteps.add(createSolutionStepFromNode(node));
        }

        System.out.println("======================");
        System.out.println("Total number of expanded nodes: " + totalNodes);
        System.out.println("Number of DG used to reach solution: " + cost);
        System.out.println("Depth of the solution: " + depth);
        System.out.println("======================");

        if (visualize) {
            for (int i = solutionSteps.size() - 1; i >= 0; i--) {
                System.out.println(solutionOperators.get(i) != null ? solutionOperators.get(i) : "Initial State");
                System.out.println("======================");
                WesterosMap.printGrid(solutionSteps.get(i));
                System.out.println("======================");

                if (WAIT_FOR_NEXT) {
                    System.out.println("Press Enter key to show next move...");
                    try {
                        System.in.read();
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

    private char[][] createSolutionStepFromNode(Node node) {
        char[][] grid = new char[this.map.m][this.map.n];
        // fill array without JS and WW
        for (int i = 0; i < this.map.m; i++) {
            for (int j = 0; j < this.map.n; j++) {
                char cell = this.map.getGrid()[i][j];
                if (cell == WesterosMap.JS_REP || cell == WesterosMap.WW_REP || cell == WesterosMap.DEF_REP) {
                    grid[i][j] = WesterosMap.DEF_REP;
                } else if (cell == WesterosMap.D_REP){
                    grid[i][j] = cell;
                } else {
                    grid[i][j] = cell;
                }
            }
        }

        WesterosState state = (WesterosState) node.getState();
        for (Pair p : state.getWhiteWalkersPositions()) {
            grid[p.x][p.y] = WesterosMap.WW_REP;
        }
        grid[state.getPosition().x][state.getPosition().y] = WesterosMap.JS_REP;
        return grid;
    }
}

package westeros;

import generic.Node;
import generic.Solution;
import utils.Pair;
import westeros.operators.KillOperator;

import java.util.ArrayList;

public class WesterosSolution extends Solution {
    private static boolean WAIT_FOR_NEXT = true;
    private ArrayList<String[][]> solutionSteps;
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
        System.out.println("Number of expanded nodes for this solution: " + expandedNodes);
        System.out.println("Depth of the solution: " + depth);
        System.out.println("======================");

        if (visualize) {
            for (int i = solutionSteps.size() - 1; i >= 0; i--) {
                System.out.println(solutionOperators.get(i));
                System.out.println("======================");
                WesterosMap.printGrid(solutionSteps.get(i));
                System.out.println("======================");

                if (WAIT_FOR_NEXT) {
                    System.out.println("Press Enter key to continue...");
                    try {
                        System.in.read();
                    } catch (Exception ignored) {
                    }
                }
            }
        }
    }

    private String[][] createSolutionStepFromNode(Node node) {
        String[][] grid = new String[this.map.m][this.map.n];
        // fill array without JS and WW
        for (int i = 0; i < this.map.m; i++) {
            for (int j = 0; j < this.map.n; j++) {
                char cell = this.map.getGrid()[i][j];
                if (cell == WesterosMap.JS_REP || cell == WesterosMap.WW_REP || cell == WesterosMap.DEF_REP) {
                    grid[i][j] = ANSI_WHITE + WesterosMap.DEF_REP + ANSI_RESET;
                } else if (cell == WesterosMap.D_REP){
                    grid[i][j] = YELLOW_BOLD + cell + ANSI_RESET;
                } else {
                    grid[i][j] = ANSI_WHITE + cell + ANSI_RESET;
                }
            }
        }

        WesterosState state = (WesterosState) node.getState();
        for (Pair p : state.getWhiteWalkersPositions()) {
            grid[p.x][p.y] = BLUE_BOLD + WesterosMap.WW_REP + ANSI_RESET;
        }
        grid[state.getPosition().x][state.getPosition().y] = GREEN_UNDERLINED + WesterosMap.JS_REP + ANSI_RESET;
        return grid;
    }
}

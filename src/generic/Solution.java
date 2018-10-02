package generic;

import utils.Pair;
import westeros.WesterosMap;
import westeros.WesterosState;
import westeros.operators.KillOperator;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Solution {
    private ArrayList<Node> solutionNodes;
    private ArrayList<char[][]> solutionSteps;
    private ArrayList<Operator> solutionOperators;
    private WesterosMap map;
    int cost, depth, totalNodes, expandedNodes;
    boolean visualize;

    public Solution(boolean visualize, int totalNodes) {
        solutionNodes = new ArrayList<>();
        solutionSteps = new ArrayList<>();
        solutionOperators = new ArrayList<>();
        this.visualize = visualize;
        this.totalNodes = totalNodes;
        map = WesterosMap.getInstance();
    }

    public void addNode(Node node) {
        solutionNodes.add(node);
        expandedNodes++;
    }

    public void printSolution() {
        for (Node node : solutionNodes) {
            depth = Math.max(depth, node.getDepth());
            if (node.getOperator() instanceof KillOperator) cost++;
            solutionOperators.add(node.getOperator());
            solutionSteps.add(createGridFromNode(node));
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
            }
        }
    }

    private char[][] createGridFromNode(Node node) {
        char[][] grid = new char[this.map.m][this.map.n];
        // fill array without JS and WW
        for (int i = 0; i < this.map.m; i++) {
            for (int j = 0; j < this.map.n; j++) {
                char cell = this.map.getGrid()[i][j];
                if (cell != WesterosMap.JS_REP && cell != WesterosMap.WW_REP) {
                    grid[i][j] = cell;
                } else {
                    grid[i][j] = WesterosMap.DEF_REP;
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

package generic;

import java.util.ArrayList;

public abstract class Solution {
    protected ArrayList<Node> solutionNodes;
    protected ArrayList<Operator> solutionOperators;

//    protected static final String ANSI_WHITE = "\u001B[37m";
//    protected static final String ANSI_RED = "\u001B[31m";
//    protected static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
//    protected static final String BLUE_BOLD = "\033[1;34m";   // BLUE
//    protected static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
//    protected static final String ANSI_RESET = "\u001B[0m";
    protected int cost, depth, totalNodes, expandedNodes;
    protected boolean visualize;

    public Solution(boolean visualize, int totalNodes) {
        solutionNodes = new ArrayList<>();
        solutionOperators = new ArrayList<>();
        this.visualize = visualize;
        this.totalNodes = totalNodes;
    }

    public void addNode(Node node) {
        solutionNodes.add(node);
        expandedNodes++;
    }

    public abstract void printSolution();
}

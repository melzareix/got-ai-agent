package westeros;

import generic.Node;
import generic.Operator;
import generic.SearchProblem;
import generic.State;
import utils.Pair;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class SaveWesteros extends SearchProblem {

    public SaveWesteros() {
        this.initialState = setInitialState();
    }

    /**
     * Generates a random integer i the range [min, max]
     * @param min
     * @param max
     * @return an integer
     */
    public int randomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }

    /**
     * Generates grid positions for both white walkers and obstacles
     * @param count number of white walkers and obstacles
     * @param gridSize size of the grid
     * @return Set of grid positions
     */
    public TreeSet<Integer> generatePositions(int count, int gridSize) {
        TreeSet<Integer> positions = new TreeSet<>();
        while (positions.size() < count) {
            int position = randomInt(0, gridSize-2);
            positions.add(position);
        }
        return positions;
    }

    /**
     * TODO:: RANDOMIZE IT BITCHES
     * Generates a random grid
     * @param m grid rows
     * @param n grid columns
     * @param wwRange Pair represents the range of White Walkers' count
     * @param obRange Pair represents the range of obstacles' count
     * @param dgRange Pair represents the range of Dragon Glasses' count
     * @return Grid of size n*m represents the search problem
     */
    public char[][] genGrid(int m, int n, Pair wwRange, Pair obRange, Pair dgRange) {
        char [][] grid = new char[m][n];

        int ww = randomInt(wwRange.getX(), wwRange.getY());
        int ob = randomInt(obRange.getX(), obRange.getY());
        int dg = randomInt(dgRange.getX(), dgRange.getY());
        int count = ww+ob+dg;
        TreeSet<Integer> positions = generatePositions(count, m*n);

        for(int p : positions){
            int row= p/m;
            int col= p%m;
            if(ww > 0) {
                grid[row][col] = 'W';
                ww--;
            } else if(ob > 0) {
                grid[row][col] = 'O';
                ob--;
            } else {
                grid[row][col] = 'D';
                dg--;
            }
        }

        grid[m-1][n-1] = 'J';
        return grid;
    }

    @Override
    public State setInitialState() {
        return null;
    }

    @Override
    public Object makeQueue(Object prevQueue, ArrayList<Node> nodes, String strategy) {
        return null;
    }

    @Override
    public Node makeNode(State state) {
        return null;
    }

    @Override
    public ArrayList<Node> expand(Node n, Operator[] o) {
        return null;
    }

    @Override
    public boolean goalTest(State state) {
        return false;
    }
}

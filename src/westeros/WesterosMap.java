package westeros;

import utils.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;

/**
 * Singleton Class for Westeros Map.
 */
public class WesterosMap {

    private static WesterosMap singleInstance = null;

    private Random randomGenerator;
    private char[][] grid;
    private TreeSet<Pair> whiteWalkersPositions;

    public int m;
    public int n;
    public int maxGlass;

    //    private static final long RANDOM_SEED = System.currentTimeMillis();
//    private static final long RANDOM_SEED = 3;
    private static final long RANDOM_SEED = 7;
    private static final int GRID_BOUND = 8;

    private static final double WW_PERCENTAGE = 0.25;
    private static final double DSTONE_PERCENTAGE = 0.1;
    private static final double OBSTACLE_PERCENTAGE = 0.15;

    public  static final char WW_REP = 'W';
    public static final char D_REP = 'D';
    public static final char O_REP = '#';
    public static final char JS_REP = 'J';
    public static final char DEF_REP = '.';

    private WesterosMap() {
        this.randomGenerator = new Random(WesterosMap.RANDOM_SEED);
        this.whiteWalkersPositions = new TreeSet<>();
        this.genGrid();
    }

    /**
     * Generates grid positions for white-walkers, obstacles and dragon-stones.
     *
     * @param count    number of items to be generated.
     * @param gridSize size of the grid
     * @return Set of grid positions
     */
    private HashSet<Integer> generatePositions(int count, int gridSize) {
        final HashSet<Integer> positions = new HashSet<>();
        while (positions.size() < count) {
            final int position = this.randomGenerator.nextInt(gridSize - 1);
            positions.add(position);
        }
        return positions;
    }

    /**
     * Generate the grid of the map.
     */
    private void genGrid() {
//        this.m = this.randomGenerator.nextInt(GRID_BOUND + 1) + 4;
//        this.n = this.randomGenerator.nextInt(GRID_BOUND + 1) + 4;
        this.m = 5;
        this.n = 5;
        final int gridSize = m * n;

        this.grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(this.grid[i], DEF_REP);
        }
        int whiteWalkerCount = (int) (WW_PERCENTAGE * gridSize);
        int obstacleCount = (int) (OBSTACLE_PERCENTAGE * gridSize);
        int dragonStoneCount = (int) (DSTONE_PERCENTAGE * gridSize);

//        this.maxGlass = this.randomGenerator.nextInt(whiteWalkerCount) + 1;
        this.randomGenerator.nextInt(whiteWalkerCount);
        this.maxGlass = 3;

        final int totalCount = whiteWalkerCount + obstacleCount + dragonStoneCount;

        HashSet<Integer> positions = generatePositions(totalCount, gridSize);

        for (int p : positions) {
            int row = p / n;
            int col = p % n;
            if (whiteWalkerCount > 0) {
                this.grid[row][col] = WW_REP;
                this.whiteWalkersPositions.add(new Pair(row, col));
                whiteWalkerCount--;
            } else if (obstacleCount > 0) {
                this.grid[row][col] = O_REP;
                obstacleCount--;
            } else if (dragonStoneCount > 0) {
                this.grid[row][col] = D_REP;
                dragonStoneCount--;
            }
        }
        this.grid[m - 1][n - 1] = JS_REP;
    }


    /**
     * Print the grid in a human readable format.
     */
    public void printGrid() {
        printGrid(this.grid);
    }

    public static void printGrid(char[][] grid) {
        for (char[] row : grid) {
            for (char e : row) {
                System.out.printf("%4c ", e);
            }
            System.out.println();
        }
    }

    public static void printGrid(String[][] grid) {
        for (String[] row : grid) {
            for (String e : row) {
                System.out.printf("%1$-10s", e);
            }
            System.out.println();
        }
    }

    /**
     * @return the generated grid.
     */
    public char[][] getGrid() {
        return grid;
    }

    public static WesterosMap getInstance() {
        if (singleInstance == null)
            singleInstance = new WesterosMap();
        return singleInstance;
    }

    public boolean isObstacle(Pair position) {
        return grid[position.getX()][position.getY()] == O_REP;
    }

    public boolean isDragonGlass(Pair position) {
        return grid[position.getX()][position.getY()] == D_REP;
    }
    /**
     * @return the positions of the white walkers in the grid.
     */
    public TreeSet<Pair> getWhiteWalkersPositions() {
        return whiteWalkersPositions;
    }
}

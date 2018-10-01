package utils;

public class Cell extends Pair {
    public Cell(int x, int y) {
        super(x, y);
    }

    public boolean isValid(int m, int n) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}

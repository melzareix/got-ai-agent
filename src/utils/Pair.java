package utils;

public class Pair implements Comparable<Pair>{
    public int x;
    public int y;

    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int compareTo(Pair o) {
        if (o.x == this.x) {
            return this.y - o.y;
        }
        return this.x - o.x;
    }
}
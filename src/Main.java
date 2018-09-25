import generic.Operator;
import westeros.SaveWesteros;
import westeros.WesterosOperator;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Operator[] s = WesterosOperator.values();
        System.out.println(Arrays.toString(s));
    }
}

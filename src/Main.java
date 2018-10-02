import strategies.BreadthFirst;
import strategies.DepthFirst;
import strategies.DepthLimitedSearch;
import strategies.IterativeDeep;
import westeros.SaveWesteros;
import westeros.WesterosState;
import westeros.operators.WesterosOperator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        SaveWesteros problem = new SaveWesteros();
        problem.printMap();

        problem.search(BreadthFirst.class, true);
//        problem.search(DepthFirst.class, true);
//        problem.search(IterativeDeep.class, true);
    }
}

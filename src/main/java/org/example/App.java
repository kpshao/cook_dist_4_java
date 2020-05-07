package org.example;

import com.github.kpshao.CookDistance;

import java.util.Arrays;
import java.util.Collections;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        double[] y = new double[]{4, 2, 3, 0, -1, -2, -5, 2};
        double[][] x = new double[][] {
                {-3},
                {-2},
                {-1},
                {0},
                {1},
                {2},
                {3},
                {5}
        };

        CookDistance cookDistance = new CookDistance(y, x);
        double[] dis = cookDistance.calculate();
        for (double d : dis) {
            System.out.println(d);
        }
    }
}

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package edu.allegheny.doubling;
import java.util.Random;
/**
 * Demonstration of algorithm for finding the maximum element of an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayMax {

  /** Returns the maximum value of a nonempty array of numbers. */
  public static double arrayMax(double[] data) {
    int n = data.length;
    double currentMax = data[0];     // assume first entry is biggest (for now)
    for (int j=1; j < n; j++)        // consider all other entries
      if (data[j] > currentMax)      // if data[j] is biggest thus far...
        currentMax = data[j];        // record it as the current max
    return currentMax;
  }

    public static double[] arrayCreator(int n){
        int arraySize = n;
        double[] array1 = new double[arraySize];
        for(int b = 0; b < arraySize; b++){
            Random rand = new Random();
            array1[b] = rand.nextDouble();
        }
        return array1;

    }

   //COPIED FROM STRINGEXPERIMENT
  public static void main(String[] args) {
    int n = 50000;                           // starting value
    int trials = 10;
    try {
      if (args.length > 0)
        trials = Integer.parseInt(args[0]);
      if (args.length > 1)
        n = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) { }
    int start = n;  // remember the original starting value


    //running arrayMax
    System.out.println("Testing arrayMax...");
    for (int t=0; t < trials; t++) {
      long startTime = System.currentTimeMillis();
      //next line implements arrayMax method, dont know if parameters are correct
      double experiment = arrayMax(arrayCreator(n));
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size
    }
    }

}



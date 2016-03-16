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
 * Demonstration of algorithms for testing three-way set disjointness.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class DisjointSet {

  /** Returns true if there is no element common to all three arrays. */
  public static boolean disjoint1(int[] groupA, int[] groupB, int[] groupC) {
    for (int a : groupA)
      for (int b : groupB)
        for (int c : groupC)
          if ((a == b) && (b == c))
            return false;           // we found a common value
    return true;                    // if we reach this, sets are disjoint
  }

  /** Returns true if there is no element common to all three arrays. */
  public static boolean disjoint2(int[] groupA, int[] groupB, int[] groupC) {
    for (int a : groupA)
      for (int b : groupB)
        if (a == b)                 // only check C when we find match from A and B
          for (int c : groupC)
            if (a == c)             // and thus b == c as well
              return false;         // we found a common value
    return true;                    // if we reach this, sets are disjoint
  }


       public static int[] arrayCreator(int n){
        int arraySize = n;
        int[] array1 = new int[arraySize];
        for(int b = 0; b < arraySize; b++){
            Random rand = new Random();
            array1[b] = rand.nextInt(100);      //integers under 100
        }
        return array1;
    }



    /**tests the two disjoint algorithms, doubling the size of n each trial
     * n is a set value for the number of characters in initial string
     * the first command line can be used to change the number of trials
     *the second command line can change n
     */
    public static void main (String[]args){
        int n = 50000;
        int trials = 10;


        //beyond this line is copied from StringExperiment
        try {
      if (args.length > 0)
        trials = Integer.parseInt(args[0]);
      if (args.length > 1)
        n = Integer.parseInt(args[1]);
    } catch (NumberFormatException e) { }
    int start = n;  // remember the original starting value

    // let's run version 2 (the quicker one) first
    System.out.println("Testing disjoint2...");
    for (int t=0; t < trials; t++) {
      long startTime = System.currentTimeMillis();
      boolean temp = disjoint2(arrayCreator(n), arrayCreator(n), arrayCreator(n));
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size
    }

    System.out.println("Testing disjoint1...");
    n = start;                               // restore n to its start value
    for (int t=0; t < trials; t++) {
      long startTime = System.currentTimeMillis();
      boolean temp = disjoint1(arrayCreator(n), arrayCreator(n), arrayCreator(n));
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size

    }

    }


}

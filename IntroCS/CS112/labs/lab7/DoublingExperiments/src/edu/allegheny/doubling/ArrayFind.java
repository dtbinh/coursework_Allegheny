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
 * Demonstration of algorithm for finding a given value within an array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
class ArrayFind {

  /** Returns index j such that data[j] == val, or -1 if no such element. */
  public static int arrayFind(int[] data, int val) {
    int n = data.length;
    int j = 0;
    while (j < n) { // val is not equal to any of the first j elements of data
      if (data[j] == val)
        return j;                    // a match was found at index j
      j++;                           // continue to next index
      // val is not equal to any of the first j elements of data
    }
    return -1;                       // if we reach this, no match found
  }

       public static int[] arrayCreator(int n){
        int arraySize = n;
        int[] array1 = new int[arraySize];
        for(int b = 0; b < arraySize; b++){
            Random rand = new Random();
            array1[b] = rand.nextInt(100);
        }
        return array1;
    }

    public static int valueCreator(){
        Random rand = new Random();
        int a = rand.nextInt(100);
        return a;
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

    System.out.println("Testing arrayCreator...");
    for (int t=0; t < trials; t++) {
      long startTime = System.currentTimeMillis();
      int temp = arrayFind(arrayCreator(n), valueCreator());
      long endTime = System.currentTimeMillis();
      long elapsed = endTime - startTime;
      System.out.println(String.format("n: %9d took %12d milliseconds", n, elapsed));
      n *= 2;                                // double the problem size
    }

    }



}

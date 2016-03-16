import java.io.*;
import java.util.*;

public class FourSumWithTiming {

    public static void main(String args[]) {
        In in = new In(args[0]);
        int[] a = in.readAllInts();

        for (int i = 1; i<4; i++){
        Stopwatch timer = new Stopwatch();
        StdOut.println("Quadruples: " + count(a));
        StdOut.println("Elapsed time: " + timer.elapsedTime());
        }


    } //main

    public static int count(int[] a) {

        int count = 0;

        for (int i = 0; i < a.length; i++) {
           // System.out.println(i);
             for (int j = i+1; j < a.length; j++) {
                for (int k = j+1; k < a.length; k++) {
                    for (int x = k+1; x < a.length; x++){
                        if (a[i] + a[j] + a[k] + a[x] == 0) {
                            count++;
                        } //if
                    } //for
                } //for
            } //for
        } //for

        return count;

    } //count

} //ThreeSumWithTiming (class)

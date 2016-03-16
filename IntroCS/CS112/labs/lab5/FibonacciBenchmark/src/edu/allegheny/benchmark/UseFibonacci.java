package edu.allegheny.benchmark;

import com.clarkware.Profiler;
import java.io.*;

public class UseFibonacci {

    public static void main(String[] args) {

        System.out.println("Begin experiment with different Fibonacci " +
                "implementations ..."); System.out.println();

        // extract the value that was passed on the command line; this is the
        // nth fibonacci number that we must calculate in the three different
        // fashions
        Integer Num = new Integer(args[0]); int num = Num.intValue();   //takes in the first number in the command line

        // determine which algorithm we are supposed to benchmark
        String chosen = args[1];        //takes in the first String argument in the command line
        String whichType = args[2];     //takes in the second String argument in the command line

        if( chosen.equals("recursive") || chosen.equals("all") ) {      //user chooses recursive or all
            if (whichType.equals("int") || whichType.equals("both")){   //user chooses int or both
            // 1. RECURSIVE fibonacci (int)
            Profiler.begin("RecursiveFibonacciInt"); int recursiveFib =
                RecursiveFibonacci.fib(num);                            //calls method for RI
            Profiler.end("RecursiveFibonacciInt");

            System.out.println("(Recursive/int) The " + num + "th Fibonacci " +
                    "number = " + recursiveFib + ".");                  //displays calculation
            }

            if (whichType.equals("long") || whichType.equals("both")){  //user chooses long or both
            // 1. RECURSIVE fibonacci (long)
            Profiler.begin("RecursiveFibonacciLong"); long recursiveFibLong =
                RecursiveFibonacci.fibLong(num);                        //calls method for RL
            Profiler.end("RecursiveFibonacciLong");

            System.out.println("(Recursive/long) The " + num + "th Fibonacci "
                    + "number = " + recursiveFibLong + ".");            //displays calculation
            }
        }

        if( chosen.equals("iterative") || chosen.equals("all") ) { //runs if user enters iterative or all

            if(whichType.equals("int") || whichType.equals("both")){    //user chooses int or both
                 // 2. ITERATIVE fibonacci (int)
                Profiler.begin("IterativeFibonacciInt"); int iterativeFib =
                IterativeFibonacci.fib(num);                            //calls method for II
                 Profiler.end("IterativeFibonacciInt");

                 System.out.println("(Iterative/int) The " + num + "th Fibonacci " +
                    "number = " + iterativeFib + ".");                      //displays calculation
            }

            if(whichType.equals("long") || whichType.equals("both")){   //user chooses long or both
                 // 2. ITERATIVE fibonacci (long)
                  Profiler.begin("IterativeFibonacciLong"); long iterativeFibLong =
                     IterativeFibonacci.fibLong(num);               //calls method for IL
                     Profiler.end("IterativeFibonacciLong");

                     System.out.println("(Iterative/long) The " + num + "th Fibonacci "
                    + "number = " + iterativeFibLong + ".");                //displays calculation
            }
        }

        System.out.println(); Profiler.print(new PrintWriter(System.out));  //Profiler time results are displayed

        System.out.println("... End experiment with different Fibonacci " +
                "implementations");

    }

}

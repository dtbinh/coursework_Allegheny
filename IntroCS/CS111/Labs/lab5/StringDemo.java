//*************************************
// SJ Guillaume
// CMPSC 111 Fall 2014
// Lab #5
// Date: 2 October 2014
//
// The purpose of this program is to illustrate several common methods
// of the String class
//*************************************

import java.util.Random;
import java.util.Date;
import java.util.Scanner;

public class StringDemo
{
    //------------------------------------
    // Program execution starts here:
    //------------------------------------
    public static void main(String[] args)
    {
        // Variable dictionary:
        Scanner scan = new Scanner(System.in); // used for input
        Random r = new Random(); // random number generator
        String s1, s2; // s1 = input by user, s2 = used in computations
        int len;       // length of string s1
        int location;  // one of the positions in string s1
        char c;        // a letter chosen randomly from a string

        System.out.println("Your name\nLab 4 String Demo Program\n"
            + new Date() + "\n----------------\n");

        System.out.print("Enter a string (no blanks allowed): ");
        s1 = scan.next();

        s1 = s1.toLowerCase();
        System.out.println("Convert input to lower case: " + s1);

        s1 = s1.toUpperCase();
        System.out.println("Convert input to upper case: " + s1);

        System.out.println("\nNext, we will insert an 'x' at a random place.");
        System.out.println("\nFirst, find the length of the string:");
        len = s1.length();
        System.out.println("   length of " + s1 + " = " + len);

        System.out.println("Next, choose a random int between 0 and " + len);
        location = r.nextInt(len+1); // do you see why we need the "+1"?
        System.out.println("   We chose: " + location);
        System.out.println("Here's everything up to location " + location + ": "
            + s1.substring(0,location));
        System.out.println("And here's everything from location: " + location
            + " onward: " + s1.substring(location));

        s2 = s1.substring(0,location) + 'x' + s1.substring(location);
        System.out.println("The new string uses these, with an 'x' in between: "
            + s2);

        System.out.println("\nNow let's replace some of the characters in " + s1);
        s2 = s1.replace('A','a');
        System.out.println("We replaced 'A' with 'a' to get: " + s2);

        s2 = s2.replace('B','b');
        System.out.println("We replaced 'B' with 'b' to get: " + s2);

        s2 = s2.replace('a','B');
        System.out.println("We replaced 'a' with 'B' to get: " + s2);

        s2 = s2.replace('b','A');
        System.out.println("We replaced 'b' with 'A' to get: " + s2);

        System.out.println("\nFinally, let's generate some random letters.");
        System.out.println("Randomly pick letters from the string PQRST.");

        c = "PQRST".charAt(r.nextInt(5)); // "PQRST" has length 5

        System.out.println("Random letter from PQRST: " + c);

        c = "PQRST".charAt(r.nextInt(5));
        System.out.println("Another random letter from PQRST: " + c);

        c = "PQRST".charAt(r.nextInt(5));
        System.out.println("And another: " + c);

        c = "PQRST".charAt(r.nextInt(5));
        System.out.println("And another: " + c);
    }
}

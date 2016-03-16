//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab #8
//Date: November 4, 2014
//
//Purpose: Enhance experience with designing and implementing my own Java classes
//and use if/else statements as part of a solution to a real-world problem
//*********************************

import java.util.Scanner;

public class SudokuChecker
{
    //private data members
    private int w1, w2, w3, w4, x1, x2, x3, x4, y1, y2, y3, y4, z1, z2, z3, z4;
    int count;
    Scanner scan = new Scanner(System.in);
    //constructor here
    public SudokuChecker()
    {
        w1=0;
        w2=0;
        w3=0;
        w4=0;
        x1=0;
        x2=0;
        x3=0;
        x4=0;
        y1=0;
        y2=0;
        y3=0;
        y4=0;
        z1=0;
        z2=0;
        z3=0;
        z4=0;
        count = 0;
    }

    public void getGrid()
    {

        System.out.println("Enter Row 1: ");
        w1 = scan.nextInt();
        w2 = scan.nextInt();
        w3 = scan.nextInt();
        w4 = scan.nextInt();
        System.out.println("Enter Row 2: ");
        x1 = scan.nextInt();
        x2 = scan.nextInt();
        x3 = scan.nextInt();
        x4 = scan.nextInt();
        System.out.println("Enter Row 3: ");
        y1 = scan.nextInt();
        y2 = scan.nextInt();
        y3 = scan.nextInt();
        y4 = scan.nextInt();
        System.out.println("Enter Row 4: ");
        z1 = scan.nextInt();
        z2 = scan.nextInt();
        z3 = scan.nextInt();
        z4 = scan.nextInt();
        System.out.println(" ");
}
    public void checkGrid()
    {

       //check regions
        if (w1 + w2 + x1 + x2 ==10)
            System.out.println("REG-1: GOOD");
        else
            {
            System.out.println("REG-1: BAD");
            count = count+1;
            }
         if (y1 + y2 + z1 + z2 ==10)
            System.out.println("REG-2: GOOD");
        else
            {
            System.out.println("REG-2: BAD");
            count = count+1;
            }
         if (w3 + w4 + x3 + x4 ==10)
            System.out.println("REG-3: GOOD");
        else
            {
            System.out.println("REG-3: BAD");
            count = count+1;
            }
         if (y3 + y4 + z3 + z4 ==10)
            System.out.println("REG-4: GOOD\n");
        else
            {
            System.out.println("REG-4: BAD\n");
            count = count+1;
            }

        //check rows
        if (w1 + w2 + w3 + w4 == 10)
            System.out.println("Row-1: GOOD");
        else
            {
            System.out.println("Row-1: BAD");
            count= count+1;
            }
        if (x1 + x2 + x3 + x4 == 10)
            System.out.println("Row-2: GOOD");
        else
            {
            System.out.println("Row-2: BAD");
            count= count+1;
            }
        if (y1 + y2 + y3 + y4 == 10)
            System.out.println("Row-3: GOOD");
        else
            {
            System.out.println("Row-3: BAD");
            count= count+1;
            }
        if (z1 + z2 + z3 + z4 == 10)
            System.out.println("Row-4: GOOD\n");
        else
            {
            System.out.println("Row-4: BAD\n");
            count= count+1;
            }

        //check columns
         if (w1 + x1 + y1 + z1 ==10)
            System.out.println("COL-1: GOOD");
        else
            {
            System.out.println("COL-1: BAD");
            count = count+1;
            }
         if (w2 + x2 + y2 + z2 ==10)
            System.out.println("COL-2: GOOD");
        else
            {
            System.out.println("COL-2: BAD");
            count = count+1;
            }
         if (w3 + x3 + y3 + z3 ==10)
            System.out.println("COL-3: GOOD");
        else
            {
            System.out.println("COL-3: BAD");
            count = count+1;
            }
         if (w4 + x4 + y4 + z4 ==10)
            System.out.println("COL-4: GOOD\n");
        else
            {
            System.out.println("COL-4: BAD\n");
            count = count+1;
            }
        //overall correctness
        if (count == 0)
            System.out.println("SUDOKU GRID IS VALID!");
        else
            System.out.println("SUDOKU GRID IS INVALID");
    }




}

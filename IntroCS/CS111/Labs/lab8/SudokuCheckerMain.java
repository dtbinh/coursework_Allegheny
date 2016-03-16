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
import java.util.Date;
public class SudokuCheckerMain
{
    public static void main (String args[])
    {
        System.out.println("SJ Guillaume\n Lab #8 \n" + new Date () + "\n");

        SudokuChecker checker = new SudokuChecker();

        //required welcome message
        System.out.println("Welcome to the Sudoku Checker! \n" );
        System.out.println("This program checks simple and"
                +"small 4x4 Sudoku grids for correctness.\n");
        System.out.println("Each column, row, and 2x2 region contains"
                + " the numbers 1 through 4 only once.\n");
        System.out.println("To check your Sudoku, enter your board"
                + " one row at a time, with each digit separated "
                +"by a space.  Hit ENTER at the end of a row.\n");

        checker.getGrid();
        checker.checkGrid();
    }
}

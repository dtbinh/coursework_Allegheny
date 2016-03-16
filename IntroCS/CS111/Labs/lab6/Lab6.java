//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 6
//Date:October 9. 2014
//
//Purpose: To use the java Math and Format classes
//*********************************

import java.util.Date;
import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Random;

public class Lab6
{
	//-------------------
	//main method: program execution begins here
	//-------------------
	public static void main (String [] args)
	{
		System.out.println("SJ Guillaume\n Lab 6 \n" + new Date () + "\n");

		//Variable dictionary: (declare variables and use comments to explain their meanings)

    double A, P, r, t, n;

    Scanner scan = new Scanner(System.in);


    System.out.println("Enter the Principle amount(initial amount you borrow or deposit): ");
    P = scan.nextDouble();
    System.out.println("Enter the number of years the amount is deposited or borrowed for: ");
    t = scan.nextDouble();
    System.out.println("Enter the number of times the interest is compounded per year: ");
    n = scan.nextDouble();


    Random rand = new Random();
    r = (double)(rand.nextInt(14)+2)/100; //to get between .02 and .15

    //calculate value of A
    double parta, partb;
    parta = (1+(r/n));
    partb = Math.pow(parta, (n*t));
    A = P*partb;

    //use Format class
    NumberFormat money = NumberFormat.getCurrencyInstance();
    NumberFormat percent = NumberFormat.getPercentInstance();

    //print the result of the caluculation and the variable values
    System.out.println("Compound interest: Amount of money accumulated after " +t+ " years: "
                        +money.format(A));
    System.out.println("Principle amount(initial amount you"
                        +" borrow or deposit): "+money.format(P));
    System.out.println("Annual rate of interest: "+percent.format(r));
    System.out.println("Number of years borrowed: "+t+" years");
    System.out.println("Number of times interest is compounded per year: "
                            +n+" times per year");

    //using same values, calculate the value for A using a continuous compounding fomula
    double partc;
    partc = Math.exp(r*t);
    A = P*partc;

    System.out.println("Continuous Compound Interest: Amount of money accumulated after " +t+ " years: "
            +money.format(A));
    System.out.println("Principle amount(initial amount you"
            +" borrow or deposit): "+money.format(P));
    System.out.println("Annual rate of interest: "+percent.format(r));
    System.out.println("Number of years borrowed: "+t+" years");






    }
}






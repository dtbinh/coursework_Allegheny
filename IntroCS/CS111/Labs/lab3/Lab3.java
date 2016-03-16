//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts. 
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 3
//Date: 18 September 2014 
//
//Purpose: Tip and Bill Caculator 
//*********************************

import java.util.Date; 
import java.util.Scanner; 

public class Lab3
{
	//-------------------
	//main method: program execution begins here
	//-------------------
	public static void main (String [] args)
	{
		System.out.println("SJ Guillaume\n Lab #3 \n" + new Date () + "\n");

		Scanner scan = new Scanner(System.in);

		//variables
		 
		double tip;
		double total;
		int people; 
		double splitBill;


		//begin program input
		System.out.println("Welcome to the Tip Calculator");
		System.out.println("What is your name?");
		String name = scan.next(); 
		System.out.println("Hello, " +name );
		System.out.println("What is the cost listed on your bill? ");
		double cost = scan.nextDouble();
		System.out.println("What percentage would you like to tip? ");
		double tipPercentage = scan.nextDouble();

		tip = tipPercentage/100 *cost;
		total = tip + cost;
		
		System.out.println(name+ ", your bill came to $" +cost);
		System.out.println("Your tip amout is $" +tip); 
		System.out.println("Your total bill is $" +total);
		System.out.println("How many people will be splitting the bill? ");
		
		people = scan.nextInt(); 
		splitBill= total/people;
 
		System.out.println(" Each person should pay $" +splitBill); 
		System.out.println("Thanks for using Tip Calculator! Have a great day!");




	}
}




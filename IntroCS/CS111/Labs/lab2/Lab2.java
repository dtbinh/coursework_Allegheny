
//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts. 
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 2
//Date: 11 September 2014
//
//Purpose: to compute and print the number of feet in a mile, the number of inches in a mile, and the number of centimeters in a mile
//*********************************

import java.util.Date; 

public class Lab2
{
	//-------------------
	//main method: program execution begins here
	//-------------------
	public static void main (String [] args)
	{
		System.out.println("SJ Guillaume\n Lab 2 \n" + new Date () + "\n");

		//Variable dictionary: (declare variables and use comments to explain their meanings)
		int meterpermile = 1609 ; // meters in a mile
		double feetpermeter = 3.28; // feet in a meter
		double halfmile; 
		double feetpermile;
		double mileandahalf;

		/*This program first calculates the number of feet in a mile 
		from the number of meters in a mile, then it uses this information 
		to calculate the number of feet in half a mile, finally, this 
		program calculates the number of feet in a mile and half by using 
		both the values previously calculated	*/

		//Compute Value: 
		feetpermile = meterpermile * feetpermeter; 

		System.out.println("Meters in a mile: " + meterpermile);
		System.out.println("Feet in a meter: " +feetpermeter);
		System.out.println("Feet in a mile: " + feetpermile); 
		System.out.println(" ");
			
		
		//Compute Value:
		halfmile = feetpermile / 2; 
		
		System.out.println("Feet in a mile: " +feetpermile); 
		System.out.println("divide by two: " + 2);
		System.out.println("Feet in half a mile: " + halfmile);
		System.out.println(" ");

		//Compute Value: 
		mileandahalf = feetpermile + halfmile;
		
		System.out.println("Feet in a mile: " +feetpermile);
		System.out.println("Feet in half a mile: " +halfmile);
		System.out.println("Feet in a mile and a half: " + mileandahalf);
		System.out.println(" ");

		// feetpermile = 5277.52
		//halfmile = 2638.76
		//mileandahalf = 7916.28 

	}
}




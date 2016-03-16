//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 5
//Date:10-02-14
//
//Purpose: The purpose of this lab is to write a program that manipulates
//strings of DNA by appropriately using methods for the String and
//Random classes.
//*********************************

import java.util.Date;
import java.util.Scanner;
import java.util.Random;

public class DnaString
{
    //-------------------
    //main method: program execution begins here
    //-------------------
    public static void main (String [] args)
    {
        System.out.println("SJ Guillaume\n Lab 5 \n" + new Date () + "\n");

        //Variable dictionary: (declare variables and use comments to explain their meanings)

        Scanner scan = new Scanner(System.in);
        Random r = new Random();
        String dnaString;
        String dnaStrComplement;



        System.out.println("Type a string of DNA comprising of the"
                + "characters A,G,C,T: ");
        dnaString = scan.nextLine();
        dnaString = dnaString.toUpperCase();
        System.out.println("You entered: \"" + dnaString +"\"");



        dnaStrComplement = dnaString.replace('A','t');
        dnaStrComplement = dnaStrComplement.replace('T','a');
        dnaStrComplement = dnaStrComplement.replace('G','c');
        dnaStrComplement = dnaStrComplement.replace('C','g');

        dnaStrComplement = dnaStrComplement.toUpperCase();
        System.out.println("print complement of the string: "
                +dnaStrComplement);



        //part 3 of lab

        int randLetter = r.nextInt(4);
        char letter = "ACGT".charAt(randLetter);

        System.out.println("Inserting " +letter+ " at position 0 gives: "+ letter+dnaString);

        //part 4 of lab
        int letterRand = r.nextInt(dnaString.length());
        String part4;
        part4= dnaString.substring(0,letterRand)+ dnaString.substring(letterRand+1);
        System.out.println("Deleting from position "+ letterRand + " gives: "+part4);

        //part 5 of lab
        String part5;
        part5 = dnaString.substring(0, letterRand) + letter + dnaString.substring(letterRand+1);
        System.out.println("Changing position "+ letterRand + " gives: " +part5);

    }
}




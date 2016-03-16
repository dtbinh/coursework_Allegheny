//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 4
//Date: 23 October 2014
//Purpose: learn more about Java Graphics and create a masterpiece drawing
//*********************************


import javax.swing.*;

public class Lab7Test
{
    public static void main(String[] args)
    {
        	JFrame window = new JFrame("SJ Guillaume ");

      		// Add the drawing canvas and do necessary things to
     		// make the window appear on the screen!
        	window.getContentPane().add(new Lab7());
        	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	window.setVisible(true);
			window.setSize(600, 600);

    }
}


//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 4
//Date: 23 October 2014
//Purpose: learn more about Java classes and methods
//*********************************


import java.awt.*;
import javax.swing.JApplet;

public class Lab7 extends JApplet
{
    //-------------------------------------------------
    // Use Graphics methods to add content to the drawing canvas
    //-------------------------------------------------
    public void paint(Graphics page)
    {
	//--------------------------------------
        //create a jack-o-lantern Pumpkin image
	//--------------------------------------

    Lab7Drawing pumpkin = new Lab7Drawing(0,0);
        pumpkin.Background(page);
        pumpkin.Pumpkin(page);
        pumpkin.PumpkinFeatures(page);

    }


}

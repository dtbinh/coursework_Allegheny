//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts. 
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 4
//Date: 25 September 2014
//Purpose: learn more about Java Graphics and create a masterpiece drawing
//*********************************


import java.awt.*;
import javax.swing.JApplet;

public class Lab4 extends JApplet
{
    //-------------------------------------------------
    // Use Graphics methods to add content to the drawing canvas
    //-------------------------------------------------
    public void paint(Graphics page)
    {
	//--------------------------------------
        //create a jack-o-lantern Pumpkin image
	//--------------------------------------
	
	//set background color to black
	setBackground(Color.black); 

	//create grass
	page.setColor(new Color (00, 0x55, 00)); 
	page.fillRect(0,550, 600, 50); 


	//create the pumpkin
	page.setColor(new Color (0xFF, 0x66, 0x00));
	page.fillOval(0,75,600,500);

	//make pumpkin ridges
	page.setColor(Color.orange);
	page.drawArc(100, 75, 400, 500, 90, 180);
	page.drawArc(100, 75, 400, 500, 180, 270);
	page.drawArc(200, 75, 200, 500, 90, 180);
	page.drawArc(200, 75, 200, 500, 180, 270);
	page.drawArc(50, 75, 500, 500, 90, 180);
	page.drawArc(50, 75, 500, 500, 180, 270);



	//create stem of pumpkin
	page.setColor(new Color (0x44,0,0)); 
	page.fillRect(275, 10, 50, 100); 
	//striation on stem
	page.setColor(new Color (0x99, 0x66, 0x33));
	page.fillRect(287, 10, 15, 100);


	//right eye
	page.setColor(Color.black);
	page.fillRect(160, 200, 100, 100); 

	//left eye
	page.setColor(Color.black); 
	page.fillRect(360, 200, 100, 100); 

	//nose
	page.fillOval(290, 320, 30, 30); 
	
	//mouth
	page.fillOval(100, 430, 400, 70); 




	




    }
}

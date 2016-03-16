//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts.
//SJ Guillaume
//CMPSC 111 Fall 2014
//Lab 7
//Date: 23 October 2013
//Purpose: gain experience in writing java classes and methods
//*********************************
import java.awt.*;
import javax.swing.JApplet;

public class Lab7Drawing


{
    //instance variables
    private int x;
    private int y;


    //constructor
    public Lab7Drawing (int x1, int y1)
    {
        x = x1;
        y = y1;
    }

    //METHODS
    public void Background(Graphics page)
    {
        //set background color to black
        page.setColor(Color.black);
        page.fillRect(x+0,y+0,600, 550);

        //create grass
        page.setColor(new Color (00, 0x55, 00));
        page.fillRect(0,550, 600, 50);
    }

   public void Pumpkin(Graphics page)
    {
        //create the pumpkin
        page.setColor(new Color (0xFF, 0x66, 0x00));
        page.fillOval(x+0,y+75,600,500);

        //make pumpkin ridges
        page.setColor(Color.orange);
        page.drawArc(x+100,y+ 75, 400, 500, 90, 180);
        page.drawArc(x+100, y+75, 400, 500, 180, 270);
        page.drawArc(x+200, y+75, 200, 500, 90, 180);
        page.drawArc(x+200, y+75, 200, 500, 180, 270);
        page.drawArc(x+50, y+75, 500, 500, 90, 180);
        page.drawArc(x+50, y+75, 500, 500, 180, 270);

        //create stem of pumpkin
        page.setColor(new Color (0x44,0,0));
        page.fillRect(x+275, y+10, 50, 100);
        //striation on stem
        page.setColor(new Color (0x99, 0x66, 0x33));
        page.fillRect(x+287, y+10, 15, 100);
    }

    public void PumpkinFeatures(Graphics page)
    {
        //right eye
        page.setColor(Color.black);
        page.fillRect(x+160, y+200, 100, 100);

        //left eye
        page.setColor(Color.black);
        page.fillRect(x+360, y+200, 100, 100);

        //nose
        page.fillOval(x+290, y+320, 30, 30);

        //mouth
        page.fillOval(x+100, y+430, 400, 70);

    }

}

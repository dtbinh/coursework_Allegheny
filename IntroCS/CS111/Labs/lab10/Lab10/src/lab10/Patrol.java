//*********************************
//Honor Code: The work I am submitting is a result of my own thinking and efforts. 
//SJ Guillaume, Arman Dashti, Rochelle Rogalski
//CMPSC 111 Fall 2014
//Lab #10
//Date: 11-20-14
//
//Purpose: Use loops, arrays, writing and calling methods, using lejos to develop programming skills.  Also to become familiar with Eclipse. 
//*********************************



package lab10;
//import lejos.nxt.Sound;
import lejos.robotics.navigation.DifferentialPilot;

import java.io.IOException;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;
import lejos.utility.PilotProps;

/**
 * @author guillaumes, Arman Dashti, Rochelle Rogalski
 *
 */
public class Patrol 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		System.out.println ("Welcome to Patrol Robot!");
		Sound.beepSequenceUp();
		
		// Create variables for motors
		RegulatedMotor leftMotor;
		RegulatedMotor rightMotor; 
				
		// Create a configuration object for the Differential Pilot
		PilotProps pp = new PilotProps();
		// Set the appropriate values for wheel diameter and track width
		// wheelDiameter - diameter of the tire
		float wheelDiameter = Float.parseFloat(pp.getProperty(PilotProps.KEY_WHEELDIAMETER, "4"));
		// trackWidth - distance between center of right tire and center of left tire
		float trackWidth = Float.parseFloat(pp.getProperty(PilotProps.KEY_TRACKWIDTH, "14.0"));
		System.out.println("Wheel diameter is " + wheelDiameter);
		System.out.println("Track width is " +trackWidth);
		leftMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
		rightMotor = PilotProps.getMotor(pp.getProperty(PilotProps.KEY_RIGHTMOTOR, "C"));
		boolean reverse = Boolean.parseBoolean(pp.getProperty(PilotProps.KEY_REVERSE,"false")); 
		// Create an instance of the robot
		// The DifferentialPilot is an abstraction of the Pilot mechanism of the robot. 
		// It contains methods to control robot movements: travel forward or backward in a straight line 
		// or a circular path or rotate to a new direction.
		DifferentialPilot robot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor,reverse);
		
		System.out.println ("Waiting for press.");
		Button.waitForAnyPress();
		
		Sound.beepSequenceUp();
		
		int count = 0;
		
		while (count <=2 )
		{
			patrol (robot);
			count++;
		}

		
	}
	
	public static void patrol(DifferentialPilot robot)
	{
		robot.setAcceleration(3000);
		robot.setTravelSpeed(20);
		robot.setRotateSpeed(50);
		robot.travel(40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(70);
		//sonicReader(robot);
		robot.travel(40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(70);
		//sonicReader(robot);
		robot.travel(40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(70);
		//sonicReader(robot);
		robot.travel(40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		
		robot.setAcceleration(2000);
		robot.setTravelSpeed(30);
		robot.travel(-40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(-70);
		//sonicReader(robot);
		robot.travel(-40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(-70);
		//sonicReader(robot);
		robot.travel(-40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
		robot.rotate(-70);
		sonicReader(robot);
		robot.travel(-40);
		Delay.msDelay(2000);
		Sound.beepSequenceUp();
	}

	public static void sonicReader(DifferentialPilot robot)
	{
		EV3UltrasonicSensor sonicSensor = new EV3UltrasonicSensor(SensorPort.S4);
		SampleProvider sp = sonicSensor.getMode("Distance");
		float[] sample = new float[sp.sampleSize()];
		float frequency = 1;
		sp.fetchSample(sample, 0);
		if (sample[0] < 1){
			robot.stop();
			System.out.println(" Too close!");
			Sound.beep();
		}
	}
}

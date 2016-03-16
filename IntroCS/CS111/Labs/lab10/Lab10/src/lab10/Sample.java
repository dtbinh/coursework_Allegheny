/**
 * 
 */
package lab10;
import java.io.IOException;
import lejos.hardware.Button;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;
import lejos.utility.PilotProps;

/**
 * @author guillaumes
 *
 */
public class Sample 
{
	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub

		//print "Hello World!" to LCD screen
		System.out.println("Hello World!");
		//Wait for 5000 Mil.
		Delay.msDelay(5000);
		
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
		// Wait for user to press ENTER
		System.out.println("Waiting for press");
		Button.waitForAnyPress();
		// set the accelaration of the robot
		robot.setAcceleration(3000);
		// set the moving speed
		robot.setTravelSpeed(20); // cm/sec
		// set the rotation speed
		robot.setRotateSpeed(100); // deg/sec
		System.out.println("Going forward");
		// move forward
		robot.forward();
		Delay.msDelay(3000);
		System.out.println("Stopping");
		// stop
		robot.stop();
		System.out.println("Stopped");
		Delay.msDelay(2000);
		System.out.println("Going backwards");
		// move backwards
		robot.backward();
		Delay.msDelay(3000);
		System.out.println("Going left");
		// rotate left
		robot.rotateLeft();
		Delay.msDelay(1000);
		System.out.println("Going right");
		robot.rotateRight();
		Delay.msDelay(1000);
		System.out.println("Stopping");
		// stop
		robot.stop();
		
	}

}

import java.io.*;
import java.io.IOException;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.MotorPort;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.RegulatedMotor;
import lejos.hardware.motor.EV3LargeRegulatedMotor;


public class Tracking{
	public static void main (String[]args) throws IOException {
	
		RegulatedMotor leftMotor = new EV3LargeRegulatedMotor(MotorPort.B);
		RegulatedMotor rightMotor = new EV3LargeRegulatedMotor(MotorPort.C);
		DifferentialPilot pilot = new DifferentialPilot(5.6f,11.2f,
				leftMotor,rightMotor);
		
		TrackBot tb = new TrackBot(4,pilot);
		tb.run();
		tb.close();
	}
}
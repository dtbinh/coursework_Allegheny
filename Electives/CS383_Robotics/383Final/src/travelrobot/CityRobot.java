package travelrobot;

import lejos.hardware.Sound;
import lejos.utility.Delay;
import java.io.*;
import java.net.*;
import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.robotics.RegulatedMotor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.robotics.navigation.Pose;
import lejos.robotics.localization.OdometryPoseProvider;
import lejos.utility.PilotProps;
import lejos.hardware.port.SensorPort;
import lejos.robotics.SampleProvider;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.sensor.EV3ColorSensor;

public class CityRobot
{
	public static void main(String[] args)
	{
		RegulatedMotor leftMotor;
		RegulatedMotor rightMotor;
		
		/* Configuration object */
		PilotProps p = new PilotProps();
	
	
		/* Sets up parameters for Differential Pilot */
		float wheelDiameter = Float.parseFloat(p.getProperty(PilotProps.KEY_WHEELDIAMETER, "4.6"));
		float trackWidth = Float.parseFloat(p.getProperty(PilotProps.KEY_TRACKWIDTH, "14.0"));
		leftMotor = PilotProps.getMotor(p.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
		rightMotor = PilotProps.getMotor(p.getProperty(PilotProps.KEY_RIGHTMOTOR, "C"));
		
		//Robot Differential Pilot	
		DifferentialPilot robot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor);
		OdometryPoseProvider pp = new OdometryPoseProvider(robot);
		robot.addMoveListener(pp);
		Pose ps = pp.getPose();
		
		//Set up color sensoracross = distance;
		EV3ColorSensor color = new EV3ColorSensor(SensorPort.S3);
		SampleProvider sp = color.getColorIDMode();
		float[] sample = new float[sp.sampleSize()];
		int count = 1;
		int distance = 0;
		int across = 0;
		sp.fetchSample(sample, 0);
		while(sample[0] != 0.0) {
			if(sample[0] == 6) {
				if(count%2 == 0) {
					robot.rotate(-65);
					robot.travel(20);
					robot.rotate(-65);
					distance = 0;
					count++;
				} else {
					robot.rotate(65);
					robot.travel(20);
					robot.rotate(65);
					across = distance;
					distance = 0;
					count++;
				}
			}
			
			robot.travel(10);
			distance += 10;
			sp.fetchSample(sample, 0);
			System.out.println(sample[0]);
		}
		int y = (count-1)*20;
		int x = 0;
		if(count%2 == 0) {
			x = across - distance;
		} else {
			x = distance;
		}
		
		System.out.println(x + " " + y);
		String data =  x + " " + y;
		color.close();
		try {
			ServerSocket srvr = new ServerSocket(1234);
			Socket skt = srvr.accept();
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			out.print(data);
			Sound.beep();
	        Delay.msDelay(2000);
	        
	        out.close();
	        skt.close();
	        srvr.close();
		} catch (Exception e) {
			System.out.println("Error Server");
			e.printStackTrace();
		}
	}
}
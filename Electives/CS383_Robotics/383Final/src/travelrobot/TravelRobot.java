package travelrobot;

import java.util.Scanner;
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
import lejos.hardware.Brick;
import lejos.hardware.BrickFinder;
import lejos.hardware.BrickInfo;
import lejos.remote.ev3.RemoteEV3;
import lejos.utility.Delay;
import lejos.hardware.port.Port;
import lejos.hardware.port.UARTPort;
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.hardware.Sound;
import lejos.remote.ev3.RMISampleProvider;

public class TravelRobot
{
	public static void main(String[] args) throws Exception
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
		int xr = 0;
		int yr =0;
		try {
			Socket skt1 = new Socket("141.195.226.85", 1234);
			Scanner scan1 = new Scanner(new InputStreamReader(skt1.getInputStream()));
			Sound.buzz();
			Delay.msDelay(5000);

			//while (!scan.ready()) {}

			xr = scan1.nextInt();
			yr = scan1.nextInt();

	        scan1.close();
	        skt1.close();
		} catch(Exception e) {
			System.out.println("Error Client");
			e.printStackTrace();
		}

		System.out.println(xr + ", " + yr);

		int xb = 0;
		int yb = 0;

		try {
			Socket skt2 = new Socket("141.195.226.88", 1234);
			Scanner scan2 = new Scanner(new InputStreamReader(skt2.getInputStream()));
			Sound.buzz();
			Delay.msDelay(5000);

			//while (!scan.ready()) {}

			xb = scan2.nextInt();
			yb = scan2.nextInt();

	        scan2.close();
	        skt2.close();
		} catch(Exception e) {
			System.out.println("Error Client");
			e.printStackTrace();
		}
		System.out.println(xb + ", " + yb);

		int xg =0;
		int yg = 0;

		try {
			Socket skt3 = new Socket("141.195.226.87", 1234);
			Scanner scan3 = new Scanner(new InputStreamReader(skt3.getInputStream()));
			Sound.buzz();
			Delay.msDelay(5000);

			//while (!scan.ready()) {}

			xg = scan3.nextInt();
			yg = scan3.nextInt();

	        scan3.close();
	        skt3.close();
		} catch(Exception e) {
			System.out.println("Error Client");
			e.printStackTrace();
		}
		System.out.println(xg + ", " + yg);

		//calculate individual distances
		double distanceHR = Math.sqrt(Math.abs(Math.pow(xr, 2))+Math.abs(Math.pow(yr, 2)));
		double distanceHB = Math.sqrt(Math.abs(Math.pow(xb, 2))+Math.abs(Math.pow(xb, 2)));
		double distanceHG = Math.sqrt(Math.abs(Math.pow(xg, 2))+Math.abs(Math.pow(yg, 2)));
		double distanceRG = Math.sqrt(Math.abs(Math.pow((xr - xg), 2))+Math.abs(Math.pow((yr-yg), 2)));
		double distanceRB = Math.sqrt(Math.abs(Math.pow((xr - xb), 2))+Math.abs(Math.pow((yr-yb), 2)));
		double distanceGB = Math.sqrt(Math.abs(Math.pow((xg - xb), 2))+Math.abs(Math.pow((yg-yb), 2)));
		//calculate route distances
		double distanceA= distanceHR + distanceRB + distanceGB +distanceHG;
		double distanceB= distanceHR + distanceRG + distanceGB +distanceHB;
		double distanceC= distanceHB + distanceRB + distanceRG +distanceHG;

		//go on the most optimal path
		if (distanceA < distanceB && distanceA < distanceC){
			//travel HRBGH route
			//go to red
			robot.travel(xr);
			robot.rotate(65);
			robot.travel(yr);
			//go to blue
			robot.rotate(-65);
			robot.travel(xb-xr);
			robot.rotate(65);
			robot.travel(yb-yr);
			//go to green
			robot.rotate(-65);
			robot.travel(xg-xb);
			robot.rotate(65);
			robot.travel(yg-yb);
			//go to home
			robot.rotate(-65);
			robot.travel(xg);
			robot.rotate(65);
			robot.travel(yg);
		}
		else if (distanceB < distanceA && distanceB < distanceC){
			//travel HRGBH route
            //go to red
            robot.travel(xr);
            robot.rotate(65);
            robot.travel(yr);
            //go to green
            robot.rotate(-65);
            robot.travel(xg-xr);
            robot.rotate(65);
            robot.travel(yg-yr);
            //go to blue
            robot.rotate(-65);
            robot.travel(xg-xb);
            robot.rotate(65);
            robot.travel(yg-yb);
            //go home
            robot.rotate(-65);
            robot.travel(xb);
            robot.rotate(65);
            robot.travel(yb);
		}
		else{
			//travel HBRGH route
            //go to blue
            robot.travel(xb);
            robot.rotate(65);
            robot.travel(yb);
            //go to red
            robot.rotate(-65);
            robot.travel(xr-xb);
            robot.rotate(65);
            robot.travel(yr-yb);
            //go to green
            robot.rotate(-65);
            robot.travel(xg-xr);
            robot.rotate(65);
            robot.travel(yg-yr);
            //ET go home
            robot.rotate(-65);
            robot.travel(xg);
            robot.rotate(65);
            robot.travel(yg);
		}


			/*
		ArrayList<Double> distances = new ArrayList();
		distances.add(distanceR);
		distances.add(distanceB);
		distances.add(distanceG);

		double min = distances[0]
		int count = 0;
		int i = 0;
		while(count<2) {
			if(min<distance[count]){
				min = distance[count];
				i = count;
			}
		}

		distances.
		*/
	}

}

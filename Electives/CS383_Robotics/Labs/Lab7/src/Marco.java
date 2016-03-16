import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;

import lejos.utility.KalmanFilter;
import lejos.utility.Matrix;
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
import lejos.utility.Delay;

public class Marco {
	public static void main(String[] args) {
		int findNumObj = 3;
		
		/* Motors */
		RegulatedMotor leftMotor;	
		RegulatedMotor rightMotor;
		
		/* Configuration object */
		PilotProps p = new PilotProps();
		
		
		/* Sets up parameters for Differential Pilot */
		float wheelDiameter = Float.parseFloat(p.getProperty(PilotProps.KEY_WHEELDIAMETER, "4.6"));
		float trackWidth = Float.parseFloat(p.getProperty(PilotProps.KEY_TRACKWIDTH, "14.0"));
		leftMotor = PilotProps.getMotor(p.getProperty(PilotProps.KEY_LEFTMOTOR, "B"));
		rightMotor = PilotProps.getMotor(p.getProperty(PilotProps.KEY_LEFTMOTOR, "C"));
		
		DifferentialPilot robot = new DifferentialPilot(wheelDiameter,trackWidth,leftMotor,rightMotor);
		OdometryPoseProvider pp = new OdometryPoseProvider(robot);
		robot.addMoveListener(pp);
		Pose ps = pp.getPose();
		//System.out.println(ps.getX() + " " + ps.getY());
		
		//first sensor
		EV3UltrasonicSensor ultra1 = new EV3UltrasonicSensor(SensorPort.S2); 
		SampleProvider sp = ultra1.getDistanceMode();
		float[] sample = new float[sp.sampleSize()];
		//second sensor
		EV3UltrasonicSensor ultra2 = new EV3UltrasonicSensor(SensorPort.S4);
		SampleProvider sp2 = ultra2.getDistanceMode();
		float[] sample2 = new float[sp2.sampleSize()];
		
		
		//have robot measure the distance to objects and then rotate 5 degrees
		//Store the distance after performing sensor fusion to the array list
		//iterate through loops until the predetermined number of objects are found
		//add timing element to this process
		//need a way to store the degree rotation
		
		ArrayList<Polo> foundObjects = new ArrayList<Polo>(180);
		int degrees = 0;
		
		long startTime = System.currentTimeMillis();
		
			int index = 0;
			while(degrees<=180){
				
				Delay.msDelay(3000);
				sp.fetchSample(sample, 0);
				sp2.fetchSample(sample2, 0);
				double distance1 = (double)sample[0];
				double distance2 = (double)sample2[0];
					if(distance1<=1 && distance2 <=1){
						double fusion = (distance1 + distance2)/2;
						Polo polo = new Polo(fusion, degrees);
						foundObjects.add(index, polo);
						index++;
						System.out.println("Found Object " + fusion);
						robot.rotate(20);
						degrees += 20; 
					} //if
				degrees = degrees+10;
				robot.rotate(10);
			} //while


			int hold1 = 0;
			int hold2 = 1;
			int minDeg = foundObjects.get(1).getDeg() - foundObjects.get(0).getDeg();
			while(foundObjects.size()>findNumObj){
				for(int i = 2; i<foundObjects.size(); i++){
					int hold = foundObjects.get(i).getDeg() - foundObjects.get(i-1).getDeg();
					if(hold<minDeg){
						minDeg = hold;
						hold1 = i-1;
						hold2 = i;
						
					} //if
				} //for
				
				Polo dPolo = foundObjects.get(hold2);
				foundObjects.remove(hold2);
				foundObjects.get(hold1).setDist((dPolo.getDist() + foundObjects.get(hold1).getDist())/2);
				foundObjects.get(hold1).setDeg((dPolo.getDeg()+foundObjects.get(hold1).getDeg())/2);
			} //while
			
		long endTime = System.currentTimeMillis();
		long totalTime = endTime - startTime;
		System.out.println("Total time for first loop: " +totalTime);
		System.out.println(foundObjects.get(0).getDist());
		Delay.msDelay(5000);
		
		System.out.println("ready");
		while(Button.ESCAPE.isUp()){}
		long startTime2 = System.currentTimeMillis();
	
		int turnA = 0;
		int turnB = 0;
		
		System.out.println(foundObjects.size());
		robot.rotate(-180);
		//make first turn
		turnA = foundObjects.get(0).getDeg();
		robot.rotate(turnA);
		System.out.println(foundObjects.get(0).getDist());
		robot.travel(foundObjects.get(0).getDist()*100);
		robot.travel(-(foundObjects.get(0).getDist())*100);
		
		turnB = foundObjects.get(1).getDeg();
		robot.rotate(turnB-turnA);
		turnA = turnB;
		robot.travel(foundObjects.get(1).getDist()*100);
		robot.travel(-(foundObjects.get(1).getDist())*100);
		
		turnB = foundObjects.get(2).getDeg();
		robot.rotate(turnB-turnA);
		turnA = turnB;
		robot.travel(foundObjects.get(2).getDist()*100);
		robot.travel(-(foundObjects.get(2).getDist())*100);
		
		
		/*
		for(int i = foundObjects.size(); i>=0; i--){
			turnA = foundObjects.get(i).getDeg();
			turnB = foundObjects.get(i--).getDeg();
			int turnNow = turnB-turnA;
			robot.rotate(turnNow);	
			System.out.println(foundObjects.get(i--).getDist());
			robot.travel(foundObjects.get(i--).getDist());
			robot.travel(-(foundObjects.get(i--).getDist()));
		}
		*/
		
		long endTime2 = System.currentTimeMillis();
		long totalTime2 = startTime2 - endTime2;
		System.out.println("Total time for second loop to tap objects" + totalTime2);
		
		ultra1.close();
		ultra2.close();
		
	} //main
} //Marco
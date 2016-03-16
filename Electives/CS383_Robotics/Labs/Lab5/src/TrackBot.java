import java.io.*;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.hardware.port.Port;
import lejos.hardware.Button;
import lejos.robotics.SampleProvider;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.utility.Delay;
import lejos.hardware.sensor.EV3GyroSensor;
import lejos.hardware.lcd.LCD;


public class TrackBot{
	
	
	EV3UltrasonicSensor sensor;
	float[] samples;
	float currentSample;
	DifferentialPilot pilot;
	float frequency;
	SampleProvider  sp;
	
	
	
	public TrackBot(Port p, DifferentialPilot dp){
		frequency = 100;
		sensor = new EV3UltrasonicSensor(p);
		sp = sensor.getDistanceMode();
		pilot = dp;
		pilot.setTravelSpeed(20);  // cm per second
		
	}
	
	
	public void run(){
		boolean conditionFound = true;
		int angle = 0; 
		
		while (Button.ESCAPE.isUp()) {
			sp.takeSamples();
			currentSample = samples[0];
			
			//set boolean condition
			if (currentSample >0){conditionFound = true;}
			else {conditionFound = false;}
			
			//enter into loops
			while(conditionFound == true){
					double distance = currentSample - 0.1;
					pilot.travel(distance);
					
					if (currentSample == 0){
						pilot.stop();
						conditionFound = false;
					}
			}
			while (conditionFound == false){
					pilot.rotate(10);
					angle += angle + 10;
					LCD.clear();
					LCD.drawString(getDirection(angle), 100, 100);
					this.takeSamples();
					currentSample = samples[0];
					if (currentSample > 0){conditionFound = true;}
					
			}
		}	
		
	}
	
	
	private static String getDirection(int angle) {
		angle = angle % 360;
		if (angle < 45 || angle > 315) {
			return angle + " North";
		}
		else if (angle > 45 && angle < 135) {
			return angle + " West";
		}
		else if (angle > 135 && angle < 225) {
			return angle + " South";
		}
		else {
			return angle + " East";
		}
	}


	
	public void close(){
		sensor.close();
	}
	
}
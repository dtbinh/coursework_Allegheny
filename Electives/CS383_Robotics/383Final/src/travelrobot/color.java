package travelrobot;

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
import lejos.remote.ev3.RMIRegulatedMotor;
import lejos.hardware.Sound;
import lejos.remote.ev3.RMISampleProvider;

public class color {
	
	public static void main(String[] args) {
		EV3ColorSensor cs = new EV3ColorSensor(SensorPort.S3);
		cs.close();
	}
}
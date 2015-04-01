package org.usfirst.frc.team5427.robot.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Config
{
	ArrayList<ConfObjectInt> ports = new ArrayList<ConfObjectInt>();
	ArrayList<ConfObjectInt> limiterPorts = new ArrayList<ConfObjectInt>();
	ArrayList<ConfObjectBool> reverse = new ArrayList<ConfObjectBool>();
	ArrayList<ConfObjectDoub> forwardOffsets = new ArrayList<ConfObjectDoub>();
	ArrayList<ConfObjectDoub> backwardOffsets = new ArrayList<ConfObjectDoub>();
	
	public Config(){
		try
		{
			Scanner scan = new Scanner(new File("config.cfg"));
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//TODO scan config -
		//scan lines 1 by 1 until reaching one that starts with '--'
		//then switch to that arraylist and start puttin name-var combos
		//repeat until bottom
		//make a function that gets the variables from arraylists
		//could also use a map -- might be better (or a set, whichever one has key-variable combos
		
	}
	// NOT YET FUNCTIONAL -- TEMP VERSION BELOW

	public static final int startingPosition = 1;
	//1 = 
	//2 = 
	//3 = 
	
	// Ports
	public static final int frontLeftPort = 0;
	public static final int frontRightPort = 1;
	public static final int rearLeftPort = 2;
	public static final int rearRightPort = 3;
	public static final int liftPort = 4;
	public static final int armPort = 5;
	public static final int joystickPort = 0;
	public static final int liftTop = 0;
	public static final int liftBottom = 1;
	public static final int armsOut = 3;
	public static final int armsIn = 2;

	// Direction
	public static final boolean frontLeftIsReverse = true;
	public static final boolean frontRightIsReverse = false;
	public static final boolean rearLeftIsReverse = true;
	public static final boolean rearRightIsReverse = false;

	// Offsets
	public static final double frontLeftForwardOffset = 0;
	public static final double frontLeftBackwardOffset = 0.01;
	public static final double frontRightForwardOffset = 0.025;
	public static final double frontRightBackwardOffset = 0;
	public static final double rearLeftForwardOffset = .02;
	public static final double rearLeftBackwardOffset = .01;
	public static final double rearRightForwardOffset = .05;
	public static final double rearRightBackwardOffset = 0;

	// Arm and lift speeds
	public static final double armSpeed = .75;
	public static final double liftSpeed = .8;

}

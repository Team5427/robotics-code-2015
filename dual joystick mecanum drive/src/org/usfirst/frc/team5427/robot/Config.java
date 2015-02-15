package org.usfirst.frc.team5427.robot;

public class Config
{

	// NOT YET FUNCTIONAL -- WILL EVENTUALLY MAKE A CFG FILE FOR THIS

	// Ports
	public static final int frontLeftPort = 0;
	public static final int frontRightPort = 1;
	public static final int rearLeftPort = 2;
	public static final int rearRightPort = 3;
	public static final int liftPort = 4;
	public static final int armPort = 5;

	// Direction
	public static final boolean frontLeftIsReverse = true;
	public static final boolean frontRightIsReverse = false;
	public static final boolean rearLeftIsReverse = true;
	public static final boolean rearRightIsReverse = false;

	// Offsets
	/*
	 * TODO change the offsets to the values in Robot.java, these are old and
	 * outdated
	 */
	public static final double frontLeftForwardOffset = .0333;
	public static final double frontLeftBackwardOffset = .0333;
	public static final double frontRightForwardOffset = 0;
	public static final double frontRightBackwardOffset = 0;
	public static final double rearLeftForwardOffset = .03;
	public static final double rearLeftBackwardOffset = .03;
	public static final double rearRightForwardOffset = .003;
	public static final double rearRightBackwardOffset = .003;

	// Arm and lift speeds
	public static final double armSpeed = .5;
	public static final double liftSpeed = .5;

}

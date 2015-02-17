package org.usfirst.frc.team5427.robot;



/**
 * @author Andrew Kennedy
 * 
 * This class is used to control the motor for the arm, methods in this class just make the motor
 * that controls the arms easier to control.
 *
 */
public class Arm
{
	
	ArmVictor a;

	/**
	 * @param a
	 */
	public Arm(ArmVictor a)
	{
		this.a = a;
	}

	/**
	 * Moves the arms away from each other and hence ungrabs the object the robot is holding
	 * 
	 */
	public void ungrab()
	{
		a.backward();
	}

	/**
	 * 
	 */
	public void stop()
	{
		a.stop();
	}

	/**
	 * 
	 */
	public void grab()
	{
		a.forward();
	}
}

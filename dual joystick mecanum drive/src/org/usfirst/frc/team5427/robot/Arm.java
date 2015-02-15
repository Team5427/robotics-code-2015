package org.usfirst.frc.team5427.robot;

public class Arm
{
	/*
	 * controls the motor for the arm, methods in this class just make the motor
	 * that controls the arms easier to control
	 */
	ConstantSteelVictor a;

	public Arm(ConstantSteelVictor a)
	{
		this.a = a;
	}

	public void ungrab()
	{
		a.backward();
	}

	public void stop()
	{
		a.stop();
	}

	public void grab()
	{
		a.forward();
	}
}

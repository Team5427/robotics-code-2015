package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Victor;

abstract public class ConstantSteelVictor extends Victor
{
	/*
	 * similar to the Talon SpeedController, but it can only be set to one speed
	 * that is determined when the
	 * ConstantSteelTalon is intitialized
	 */
	double speed;

	public ConstantSteelVictor(int channel, double speed)
	{
		super(channel);
		this.speed = speed;
	}

	abstract public void forward();

	abstract public void backward();

	abstract public void stop();
	
}

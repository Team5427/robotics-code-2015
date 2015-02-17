package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Victor;

abstract public class ConstantSteelTalon extends Talon
{
	/*
	 * similar to the Talon SpeedController, but it can only be set to one speed
	 * that is determined when the
	 * ConstantSteelTalon is intitialized
	 */
	double speed;

	public ConstantSteelTalon(int channel, double speed)
	{
		super(channel);
		this.speed = speed;
	}

	public void forward()
	{
		super.set(speed);
		Feed();
	}

	public void backward()
	{
		super.set(-1 * speed);
		Feed();
	}

	public void stop()
	{
		super.set(0);
		Feed();
	}

}

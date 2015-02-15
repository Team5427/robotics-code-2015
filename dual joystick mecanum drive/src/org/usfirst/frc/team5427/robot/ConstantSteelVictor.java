package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Victor;

public class ConstantSteelVictor extends Victor
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

	public void forward()
	{
		super.set(speed);
		Feed();
	}

	public void backward()
	{
		//TODO temp solution
		super.set((-1 * speed)/3);
		Feed();
	}

	public void stop()
	{
		super.set(.1);
		Feed();
	}

}

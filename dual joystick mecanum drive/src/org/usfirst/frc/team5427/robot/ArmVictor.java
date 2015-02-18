package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class ArmVictor extends ConstantSteelVictor
{

	DigitalInput outwards, inwards;

	public ArmVictor(int channel, double speed, DigitalInput outwards, DigitalInput inwards)
	{
		super(channel, speed);
		this.outwards = outwards;
		this.inwards = inwards;
		// TODO may need to switch the digitalinputs
	}

	public void forward()
	{
		if (inwards.get())
		{
			super.set(speed);
			Feed();
		}
	}

	public void backward()
	{
		if (outwards.get())
		{
			super.set(-1 * speed);
			Feed();
		}
	}

	public void stop()
	{
		super.set(0);
		Feed();
	}
}

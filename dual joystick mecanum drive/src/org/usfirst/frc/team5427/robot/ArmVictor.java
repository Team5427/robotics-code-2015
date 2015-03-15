package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class ArmVictor extends ConstantSteelVictor
{

	DigitalInput outwards, inwards;

	public ArmVictor(int channel, double speed, DigitalInput outwards, DigitalInput inwards)
	{
		super(channel, speed);
		this.outwards = inwards;
		this.inwards = outwards;
		// TODO may need to switch the digitalinputs
	}

	public void forward()
	{
		if (outwards.get())
		{
			super.set(-1 * speed);
			Feed();
		}else stop();
		
	}

	public void backward()
	{
		if (inwards.get())
		{
			super.set(speed);
			Feed();
		}else stop();
	}

	public void stop()
	{
		super.set(0);
		Feed();
	}
}

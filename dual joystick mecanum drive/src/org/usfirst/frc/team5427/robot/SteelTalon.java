package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;

public class SteelTalon extends Talon
{
	/*
	 * SteelTalon is similar to the basic Talon class, but it was created to
	 * meet our team's needs
	 * by allowing motors to be permanently reversed(a requirement due to the
	 * design of the mecanum wheels, and
	 * how two of the gearboxes are backwards), as well as adding an offset to
	 * the wheels, increasing the speed of all of
	 * the wheels to match the fastest one, so that our robot will be able to
	 * drive straight.
	 */
	boolean reverse;
	double backwardoffset, forwardOffset;

	// TODO backwardOffset and forwardOffset may need to be switched!

	public SteelTalon(int channel, boolean r, double backwardOffset, double forwardOffset)
	{
		super(channel);
		this.backwardoffset = backwardOffset;
		this.forwardOffset = forwardOffset;
		reverse = r;
	}

	@Override
	public void set(double speed)
	{
		if (speed > .02)
			speed += forwardOffset;
		else if (speed < -.02) speed -= backwardoffset;

		/*
		 *  ensures that the speed plus/minus the offset will not exceed the
		 *  maximum values that .set can recieve
		 */

		if (speed > 1) speed = 1;
		if (speed < -1) speed = -1;
		if (reverse)
		{
			super.set(-1 * speed);
		} else
		{
			super.set(speed);
		}
		Feed();
	}

}

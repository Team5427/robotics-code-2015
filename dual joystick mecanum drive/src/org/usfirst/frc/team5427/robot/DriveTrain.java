package org.usfirst.frc.team5427.robot;

import org.usfirst.frc.team5427.robot.config.Config;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrain
{
	SpeedController fl, fr, rl, rr;
	Joystick j;
	Buttons b;

	/*
	 * class that handles everything to do with moving the robot.
	 * it enables the robot to drive like a car, or strafe side to side.
	 */
	public DriveTrain(SteelVictor fl, SteelVictor fr, SteelVictor rl, SteelVictor rr, Joystick j)
	{
		this.fl = fl;
		this.fr = fr;
		this.rl = rl;
		this.rr = rr;
		this.j = j;
		b = new Buttons(j);
		driveManager();
	}

	public void driveManager()
	{
		/*
		 * checks whether or not a button on the joystick is being held down,
		 * and
		 * switches between and only-strafing mode, and an only-driving mode
		 * accordingly.
		 * This method is called periodically by RobotMaster
		 */
		if (b.toggle() == true)
		{
			strafing();
		} else
		{
			drive();
		}

	}

	/*
	 * method for driving the robot, enables the robot to drive similarly to the
	 * car, accepting
	 * the joystick's y-value, as well as twist amount to determine how fast to
	 * drive, as well as
	 * what ratio to move the left wheels vs the right wheels, causing it to
	 * turn.
	 */
	public void drive()
	{
		/*
		 * sets the offsets back to normal, so that if the switching button on
		 * the joystick was recently pressed,
		 * the robot will still be able to drive in a straight line because the
		 * offsets will be different while
		 * strafing.
		 */
/*
		fl = new SteelTalon(0, true, 0.04, 0);
		fr = new SteelTalon(1, false, 0, 0.023);
		rl = new SteelTalon(2, true, 0.04, 0.015);
		rr = new SteelTalon(3, false, 0.002, 0.035);
		*/
		((SteelVictor) fl).changeOffsets(Config.frontLeftBackwardOffset, Config.frontLeftForwardOffset );
		((SteelVictor) fr).changeOffsets(Config.frontRightBackwardOffset, Config.frontRightForwardOffset);
		((SteelVictor) rl).changeOffsets(Config.rearLeftBackwardOffset, Config.rearRightForwardOffset);
		((SteelVictor) rr).changeOffsets(Config.rearRightBackwardOffset, Config.rearRightForwardOffset);
		
		double y = j.getY();
		double z = j.getZ();
		double left = 0;
		double right = 0;
		boolean b = false;
		if (z >= 0)
		{
			z = 1 - z;
			b = true;
		} else
		{
			z = z + 1;
			b = false;
		}
		if (b)
		{
			right = y * z;
			left = y;
		} else
		{
			left = y * z;
			right = y;
		}

		fl.set(left);
		rl.set(left);
		fr.set(right);
		rr.set(right);

	}

	/*
	 * controls the back wheels and front wheels seperately, making them either
	 * go towards or
	 * away from each other, causing the robot to move side to side due to how
	 * the mecanum wheels work.
	 */
	public void strafing()
	{
		/*
		 * changes the offsets of the wheels to account for different amounts of
		 * friction on different wheels
		 */
		/*
		fl = new SteelTalon(0, true, 0., 0);
		fr = new SteelTalon(1, false, 0, 0);
		rl = new SteelTalon(2, true, 0, 0);
		rr = new SteelTalon(3, false, 0, 0);
		*/
		double x = j.getX();
		if (x > 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
		}

		else if (x < 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
		}
	}
}

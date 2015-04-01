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
		if (b.rotate())
		{
			rotate();
		} else if (b.toggle())
		{
			strafing();
		} else if (b.turbo())
		{
			fr.set(0);
			fl.set(0);
			rr.set(-.9);
			fl.set(-.9);
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

	public void advancedDriving()
	{
		// TODO this method is in the development phases and is yet to be
		// tested.
		double x = j.getX();
		double y = j.getY();
		double z = -j.getZ() / 2;
		double resultant = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
		double angle = j.getDirectionRadians() + (Math.PI / 4);

		double front_left = resultant * Math.sin(angle) + z;
		double front_right = resultant * Math.cos(angle) - z;
		double rear_left = resultant * Math.cos(angle) + z;
		double rear_right = resultant * Math.sin(angle) - z;

		if (front_left > 1)
			front_left = 1;
		else if (front_left < -1) front_left = -1;
		if (front_right > 1)
			front_right = 1;
		else if (front_right < -1) front_right = -1;
		if (rear_left > 1)
			rear_left = 1;
		else if (rear_left < -1) rear_left = -1;
		if (rear_right > 1)
			rear_right = 1;
		else if (rear_right < -1) rear_right = -1;

		fl.set(front_left);
		fr.set(front_left);
		rl.set(rear_left);
		rr.set(rear_right);
		// andrew is a good coder and make program work good
		// andrew is better tully andrew is tully 2.0 beta.

	}

	public void rotate()
	{
		if (j.getZ() > 0.02)
		{
			// right

			fl.set(-j.getZ());
			rl.set(-j.getZ());
			fr.set(j.getZ());
			rr.set(j.getZ());
		} else if (j.getZ() < -.02)
		{
			fl.set(-j.getZ());
			rl.set(-j.getZ());
			fr.set(j.getZ());
			rr.set(j.getZ());
		}
	}

	
	
	public void rotate(double z, long time)
	{
		if (z > 0.02)
		{
			// right

			fl.set(-z);
			rl.set(-z);
			fr.set(z);
			rr.set(z);
		} else if (z < -.02)
		{
			fl.set(-z);
			rl.set(-z);
			fr.set(z);
			rr.set(z);
		}
		try
		{
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fl.set(0);
		rl.set(0);
		fr.set(0);
		rr.set(0);
	}public void drive()
	{
		/*
		 * sets the offsets back to normal, so that if the switching button on
		 * the joystick was recently pressed,
		 * the robot will still be able to drive in a straight line because the
		 * offsets will be different while
		 * strafing.
		 */
		((SteelVictor) fl).changeOffsets(Config.frontLeftBackwardOffset, Config.frontLeftForwardOffset);
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
	public void drive(double y, double z, long time)
	{
		/*
		 * sets the offsets back to normal, so that if the switching button on
		 * the joystick was recently pressed,
		 * the robot will still be able to drive in a straight line because the
		 * offsets will be different while
		 * strafing.
		 */
		((SteelVictor) fl).changeOffsets(Config.frontLeftBackwardOffset, Config.frontLeftForwardOffset);
		((SteelVictor) fr).changeOffsets(Config.frontRightBackwardOffset, Config.frontRightForwardOffset);
		((SteelVictor) rl).changeOffsets(Config.rearLeftBackwardOffset, Config.rearRightForwardOffset);
		((SteelVictor) rr).changeOffsets(Config.rearRightBackwardOffset, Config.rearRightForwardOffset);

		//negative values make the robot go forwards
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

		left += .053;
		fl.set(left);
		rl.set(left);
		fr.set(right);
		rr.set(right);
		try
		{
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fl.set(0);
		rl.set(0);
		fr.set(0);
		rr.set(0);
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
		 * fl = new SteelTalon(0, true, 0., 0);
		 * fr = new SteelTalon(1, false, 0, 0);
		 * rl = new SteelTalon(2, true, 0, 0);
		 * rr = new SteelTalon(3, false, 0, 0);
		 */
		/*
		 * ((SteelVictor) fl).changeOffsets(.05, 0 );
		 * ((SteelVictor) fr).changeOffsets(.2, 0);
		 * ((SteelVictor) rl).changeOffsets(0, .02);
		 * ((SteelVictor) rr).changeOffsets(0, 0);
		 */
		// System.out.println("entering strafing mode");
		double x = j.getX();
		if (x < 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(-x);
			rr.set(x);
		}

		else if (x > 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(-x);
			rr.set(x);
		}
	}
	public void strafing(double x, int time)
	{
		//pos goes left
		if (x < 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(-x);
			rr.set(x);
		}

		else if (x > 0)
		{
			fl.set(x);
			rl.set(-x);
			fr.set(-x);
			rr.set(x);
		}
		try
		{
			Thread.sleep(time);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		fl.set(0);
		rl.set(0);
		fr.set(0);
		rr.set(0);
	}
}

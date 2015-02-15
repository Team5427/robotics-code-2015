package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;

public class RobotMaster implements Runnable
{
	DriveTrain d;
	Arm arm;
	Lift lift;
	Buttons button;
	Joystick j;

	public RobotMaster(DriveTrain d, Joystick j, ConstantSteelVictor l, ConstantSteelVictor a)
	{
		this.d = d;
		arm = new Arm(a);
		lift = new Lift(l);
		button = new Buttons(j);
		this.j = j;
	}

	/*
	 * Thread that checks on the joystick to see if any motors need to be moved
	 */
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.sleep(5);
				d.driveManager();
				runButtonCommands();
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Code that controls the ConstantSteelTalons, uses the Buttons class to
	 * check the status of both of the buttons that
	 * correspond with a motor, and if both are not being pushed, it will stop
	 * the motor, else it will check to see which one is
	 * being pushed and move the motor accordingly.
	 */
	public void runButtonCommands()
	{
		if (button.armGrab() && button.armUngrab())
		{
			arm.stop();
		} else
		{
			if (button.armGrab())
			{
				arm.grab();
			} else if (button.armUngrab())
			{
				arm.ungrab();
			} else
			{
				arm.stop();
			}
		}
		if (button.liftUp() && button.liftDown())
		{
			arm.stop();
		} else
		{
			if (button.liftUp())
			{
				lift.up();
			} else if (button.liftDown())
			{
				lift.down();
			} else
			{
				lift.stop();
			}
		}
	}
}

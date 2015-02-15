package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class DriveTrain
{
	SpeedController fl, fr, rl, rr;
	Joystick j;

	public DriveTrain(SpeedController fl, SpeedController fr, SpeedController rl, SpeedController rr, Joystick j)
	{
		this.fl = fl;
		this.fr = fr;
		this.rl = rl;
		this.rr = rr;
		this.j = j;
		driveManager();
	}

	public void driveManager()
	{
		while (true)
		{
			if (j.getRawButton(2) == true)
			{
				strafing();
			} else
			{
				drive();
			}
		}
	}

	public void drive()
	{
		fl = new SteelTalon(0,true,0.04,0);		//reverse master
		fr = new SteelTalon(1,false,0,0.023);   //forward master
		rl = new SteelTalon(2,true,0.04,0.015);
		rr = new SteelTalon(3,false,0.002,0.035);
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

	public void strafing()
	{
		fl = new SteelTalon(0,true,0.,0);
		fr = new SteelTalon(1,false,0,0); 
		rl = new SteelTalon(2,true,0,0);
		rr = new SteelTalon(3,false,0,0);
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

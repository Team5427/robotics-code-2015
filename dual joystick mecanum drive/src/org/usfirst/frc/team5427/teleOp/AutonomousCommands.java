package org.usfirst.frc.team5427.teleOp;

import org.usfirst.frc.team5427.robot.ArmVictor;
import org.usfirst.frc.team5427.robot.DriveTrain;
import org.usfirst.frc.team5427.robot.LiftVictor;
import org.usfirst.frc.team5427.robot.config.Config;

public class AutonomousCommands
{

	public AutonomousCommands(DriveTrain d, LiftVictor l, ArmVictor a)
	{
		int i = Config.startingPosition;
		switch (i)
		{
		case 1:
			d.drive(-.5,0,1100);
			sleep();
			d.rotate(.6,510);
			sleep();
			d.drive(-.5,0,2500);
			break;
		case 2:
			break;
		case 3:
			break;
		}
	}
	private void sleep(){
		try
		{
			Thread.sleep(1000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void methodOne(){
		
	}
	public void methodTwo(){
		
	}
	public void methodThree(){
		
	}
	
}

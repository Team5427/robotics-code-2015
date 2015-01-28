package org.usfirst.frc.team5427.robot.commands;

import org.usfirst.frc.team5427.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class Drive extends Command
{
	public Drive(){
		
	}
	protected void execute(){
		Robot.frontLeft.set(Robot.j.getY());
	}
	@Override
	protected void initialize()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	protected boolean isFinished()
	{
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	protected void end()
	{
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void interrupted()
	{
		// TODO Auto-generated method stub
		
	}
}

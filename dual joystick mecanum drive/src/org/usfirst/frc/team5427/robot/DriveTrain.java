package org.usfirst.frc.team5427.robot;


import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


public class DriveTrain
{
	SpeedController fl,fr,rl,rr;
	Joystick j;
	
	Button toggle = new JoystickButton(j, 2);
	
	public DriveTrain(SpeedController fl, SpeedController fr, SpeedController rl, SpeedController rr, Joystick j){
		this.fl = fl;
		this.fr = fr;
		this.rl = rl;
		this.rr = rr;
		this.j = j;
//		Drive d = new Drive();
		while(true){
		if(j.getRawButton(2) == true){
			double x = j.getX();
//			if(x !=0)
//				continue;
		if(x >0){
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
		}
		
		else if(x<0){	
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
	}	
		}
		else{
		double y = j.getY();
		double z = j.getZ();
		double left = 0;
		double right = 0;
		boolean b = false;
		if(z>=0){
			z = 1-z;
			b = true;
		}
		else{
			z = z+1;
			b = false;
		}
		if(b){
			right = y*z;
			left = y;
		}else{
			left = y*z;
			right = y;
		}

		fl.set(left);
		rl.set(left);
		fr.set(right);
		rr.set(right);
		
	
		}
		
		}
			/*
	
		while(true){
			try
			{

				/* Code for a basic tank drive
				
				
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}

	}



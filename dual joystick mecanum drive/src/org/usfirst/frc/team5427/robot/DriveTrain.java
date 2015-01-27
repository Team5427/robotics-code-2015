package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;



public class DriveTrain
{
	SpeedController fl,fr,rl,rr;
	Joystick j;
	
	public DriveTrain(SpeedController fl, SpeedController fr, SpeedController rl, SpeedController rr, Joystick j){
		this.fl = fl;
		this.fr = fr;
		this.rl = rl;
		this.rr = rr;
		this.j = j;
		/*
        for(int i = 0; i<50; i++){
        	rl.set(.5);
        	rr.set(-.5);
        	fr.set(-.5);
        	fl.set(.5);
        }
		*/
		while(true){
			try
			{
				/* Code for a basic tank drive
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
				*/
				
				double x = j.getX();
				if(x !=0)
					continue;
				
				Thread.sleep(5);
			} catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}

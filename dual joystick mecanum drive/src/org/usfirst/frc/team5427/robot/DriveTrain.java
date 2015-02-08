package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class DriveTrain {
	SpeedController fl, fr, rl, rr;
	Joystick j;
	Buttons button;
	Button toggle = new JoystickButton(j, 2);
	Button tOGGLe = new JoystickButton(j,5);
	Button TogglE = new JoystickButton(j,3);
	Button ToGgLe = new JoystickButton(j,6);
	Button tOgGlE = new JoystickButton(j,4);
	
	public DriveTrain(SpeedController fl, SpeedController fr,
			SpeedController rl, SpeedController rr,Joystick j) {
		//initialize stuff
		this.fl = fl;
		this.fr = fr;
		this.rl = rl;
		this.rr = rr;
		this.j = j;
		button = new Buttons(j);
	}
	
	public void drive(){
		if (button.toggle()) {
			switchMovement();
		} else{
			
			//movement
			double y = j.getY();
			double z = j.getZ();
			double left = 0;
			double right = 0;
			boolean b = false;
			if (z >= 0) {
				z = 1 - z;
				b = true;
			} else {
				z = z + 1;
				b = false;
			}
			if (b) {
				right = y * z;
				left = y;
			} else {
				left = y * z;
				right = y;
			}

			fl.set(left);
			rl.set(left);
			fr.set(right);
			rr.set(right);

		}
	}
	//sets it to strafe mode
	public void switchMovement(){
		double x = j.getX();
		if (x > 0) {
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
		}

		else if (x < 0) {
			fl.set(x);
			rl.set(-x);
			fr.set(x);
			rr.set(-x);
		}
	}
}

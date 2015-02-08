package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;
public class Buttons {
	Joystick j;
	public Buttons(Joystick j){
		this.j = j;
	}
	
	public boolean toggle(){
		return j.getRawButton(2);
	}
	public boolean liftUp(){
		return j.getRawButton(5);
	}
	public boolean liftDown(){
		return j.getRawButton(3);
	}
	public boolean armGrab(){
		return j.getRawButton(6);
	}
	public boolean armUngrab(){
		return j.getRawButton(4);	
	}
}

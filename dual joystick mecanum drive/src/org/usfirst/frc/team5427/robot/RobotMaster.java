package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;

public class RobotMaster implements Runnable{
	DriveTrain d;
	Arm arm;
	Lift lift;
	Buttons button;
	Joystick j;
	
	public RobotMaster(DriveTrain d, Joystick j, SpeedController l, SpeedController a){
		this.d = d;
		arm = new Arm(a);
		lift = new Lift(l);
		button = new Buttons(j);
		this.j = j;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
		while(true){
			Thread.sleep(5);
			d.drive();
			runButtonCommands();
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void runButtonCommands(){
		if(button.armGrab()){
			arm.grab();
		}
		if(button.armUngrab()){
			arm.ungrab();
		}
		if(button.liftUp()){
			lift.up();
		}
		if(button.liftDown()){
			lift.down();
		}
	}
}

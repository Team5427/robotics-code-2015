package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Joystick;

public class RobotMaster implements Runnable{
	DriveTrain d;
	Arm arm;
	Lift lift;
	Buttons button;
	Joystick j;
	
	public RobotMaster(DriveTrain d, Joystick j, ConstantSteelTalon l, ConstantSteelTalon a){
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
			d.driveManager();
			runButtonCommands();
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public void runButtonCommands(){
		if(button.armGrab()&&button.armUngrab()){
			arm.stop();
		}
		else{
			if(button.armGrab()){
				arm.grab();
			}
			else if(button.armUngrab()){
				arm.ungrab();
			}
			else{
				arm.stop();
			}
		}
		if(button.liftUp()&&button.liftDown()){
		arm.stop();
		}
		else{ 
			if(button.liftUp()){
				lift.up();
			}
			else if(button.liftDown()){
				lift.down();
			}
			else{
				lift.stop();
			}
		}
	}
}

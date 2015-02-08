package org.usfirst.frc.team5427.robot;


public class Arm {
	
	ConstantSteelTalon a;
	public Arm(ConstantSteelTalon a){
		this.a = a;
	}
	
	public void ungrab(){
		a.backward();
	}
	public void stop(){
		a.stop();
	}
	public void grab(){
		a.forward();
	}
}

package org.usfirst.frc.team5427.robot;


public class Lift {
	ConstantSteelTalon l;
	public Lift(ConstantSteelTalon l){
		this.l = l;
	}
	public void up(){
		l.forward();
	}
	public void stop(){
		l.stop();
	}
	public void down(){
		l.backward();
	}
}

package org.usfirst.frc.team5427.robot;

public class ArmVictor extends ConstantSteelVictor{

	public ArmVictor(int channel, double speed) {
		super(channel, speed);
	}
	public void forward(){
		super.set(speed);
		Feed();
	}

	public void backward(){
		super.set(-1 * speed / 3);
		Feed();
	}

	public void stop(){
		super.set(.1);
		Feed();
	}
}

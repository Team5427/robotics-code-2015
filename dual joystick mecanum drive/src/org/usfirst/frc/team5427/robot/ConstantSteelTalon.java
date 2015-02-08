package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;

public class ConstantSteelTalon extends Talon{
	
	double speed;
	public ConstantSteelTalon(int channel, double speed){
		super(channel);
		this.speed = speed;
	}
	
    public void forward() {
		super.set(speed);
        Feed();
    }
	
	public void backward() {
		super.set(-1*speed);
        Feed();
    }
	
	public void stop() {
		super.set(0);
        Feed();
    }
	
}

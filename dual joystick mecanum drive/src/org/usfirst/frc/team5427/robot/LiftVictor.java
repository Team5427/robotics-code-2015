package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LiftVictor extends ConstantSteelVictor{

	int toteCount = 0;
	DigitalInput heightLimiter;
	
	public LiftVictor(int channel, double speed,DigitalInput heightLimiter) {
		super(channel, speed);
		this.heightLimiter = heightLimiter;
	}
	public void forward(){
		if(!heightLimiter.get()){
		super.set(speed);
		Feed();
		}
	}

	public void backward(){
		super.set(-1 * speed / 3);
		Feed();
	}

	public void stop(){
		switch(toteCount){
			case 0: super.set(0.1);
			case 1: super.set(0.2);
			case 2: super.set(0.3);
			case 3: super.set(0.4);
			
			Feed();
		}
		
	}
	public void changeToteCount(int toteCount){
			this.toteCount = toteCount;
	}
	
}

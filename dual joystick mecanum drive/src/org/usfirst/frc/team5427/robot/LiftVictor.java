package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;

public class LiftVictor extends ConstantSteelVictor{

	int toteCount = 0;
	DigitalInput heightLimiter;
	DigitalInput bottomLimiter;
	
	public LiftVictor(int channel, double speed,DigitalInput heightLimiter, DigitalInput bottomLimiter) {
		super(channel, speed);
		this.heightLimiter = heightLimiter;
		this.bottomLimiter = bottomLimiter;
	}
	public void forward(){
		if(heightLimiter.get()){
		super.set(speed);
		Feed();
		}else stop();
	}

	public void backward(){
		if(bottomLimiter.get()){
		super.set(-1 * speed / 1.5);
		Feed();
		}else stop();
	}

	public void stop(){

		/*
		switch(toteCount){
			case 0: super.set(0.05);
			case 1: super.set(0.2);
			case 2: super.set(0.3);
			case 3: super.set(0.4);
			
			Feed();
		}
		*/
		super.set(.05);
		
	}
	public void changeToteCount(int toteCount){
			this.toteCount = toteCount;
	}
	
}

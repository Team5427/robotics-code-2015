package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;

public class SteelTalon extends Talon{
	
	boolean reverse;
	double forwardOffset,backwardsOffset;
	public SteelTalon(int channel, boolean r, double forwardOffset, double backwardsOffset){
		super(channel);
		this.forwardOffset = forwardOffset;
		this.backwardsOffset = backwardsOffset;
		reverse = r;
	}
	
	@Override
    public void set(double speed) {
		if(speed>.02)
			speed += backwardsOffset;
		else if (speed<-.02)
			speed -= forwardOffset;

		if(speed > 1) speed = 1;
		if(speed < -1) speed = -1;
		if(reverse){
		super.set(-1*speed);
		}
		else{
		super.set(speed);
		}
        Feed();
    }

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	
}

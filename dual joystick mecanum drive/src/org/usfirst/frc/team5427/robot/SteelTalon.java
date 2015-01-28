package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.Talon;

public class SteelTalon extends Talon{
	
	boolean reverse;
	public SteelTalon(int channel, boolean r) {
		super(channel);
		// TODO Auto-generated constructor stub
		reverse = r;
	}
	
	@Override
    public void set(double speed) {
		if(reverse)
		super.set(-1*speed);
		else
		super.set(speed);
        Feed();
    }

	public boolean isReverse() {
		return reverse;
	}

	public void setReverse(boolean reverse) {
		this.reverse = reverse;
	}

	
}

package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

public class SteelController extends Talon implements SpeedController{

	
	
	boolean reverse = true;
	
	public boolean isReverse()
	{
		return reverse;
	}

	public SteelController(int channel)
	{
		super(channel);

	}
/*	
	@Override
    public void set(double speed) {
		if(reverse = true)
        setSpeed(-speed);
		else setSpeed(speed);
        Feed();
    }
    */
	
}

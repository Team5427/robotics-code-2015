package org.usfirst.frc.team5427.robot;

public class Lift
{
	LiftVictor l;

	public Lift(LiftVictor l)
	{
		this.l = l;
	}

	public void up()
	{
		l.forward();
	}

	public void stop()
	{
		l.stop();
	}

	public void down()
	{
		l.backward();
	}
	public void changeToteCount(int toteCount){
		l.changeToteCount(toteCount);
	}
}

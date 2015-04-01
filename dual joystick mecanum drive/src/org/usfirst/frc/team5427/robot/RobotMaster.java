package org.usfirst.frc.team5427.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class RobotMaster implements Runnable
{
	DriveTrain d;
	Arm arm;
	Lift lift;
	Buttons button;
	Joystick j;
	int session;
	Image frame;

	public RobotMaster(DriveTrain d, Joystick j, LiftVictor l, ArmVictor a, int session,Image frame)
	{
		this.d = d;
		arm = new Arm(a);
		lift = new Lift(l);
		button = new Buttons(j);
		this.j = j;
		this.session = session;
		this.frame = frame;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 * 
	 *
	 * Thread that checks on the joystick to see if any motors need to be moved
	 *
	 */
	public void run()
	{
		try
		{
			while (true)
			{
				Thread.sleep(5);
				d.driveManager();
				 NIVision.IMAQdxStartAcquisition(session);

			        /**
			         * grab an image, draw the circle, and provide it for the camera server
			         * which will in turn send it to the dashboard.
			         */
			        NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);


			            NIVision.IMAQdxGrab(session, frame, 1);
		//	            NIVision.imaqDrawShapeOnImage(frame, frame, rect,
		//	                    DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
			            
			            CameraServer.getInstance().setImage(frame);

			            /** robot code here! **/
			            Timer.delay(0.005);		// wait for a motor update time
			        
		//	        NIVision.IMAQdxStopAcquisition(session);
				runButtonCommands();
			}
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}

	}

	/*
	 * Code that controls the ConstantSteelTalons, uses the Buttons class to
	 * check the status of both of the buttons that
	 * correspond with a motor, and if both are not being pushed, it will stop
	 * the motor, else it will check to see which one is
	 * being pushed and move the motor accordingly.
	 */
	public void runButtonCommands()
	{
		if(button.toteChange()){
			lift.changeToteCount(button.toteNumber());
		}
		
		
		if (button.armGrab() && button.armUngrab())
		{
			arm.stop();
		} else
		{
			if (button.armGrab())
			{
				arm.grab();
			} else if (button.armUngrab())
			{
				arm.ungrab();
			} else
			{
				arm.stop();
			}
		}
		
		
		if (button.liftUp() && button.liftDown())
		{
			arm.stop();
		} else
		{
			if (button.liftUp())
			{
				lift.up();
			} else if (button.liftDown())
			{
				lift.down();
			} else
			{
				lift.stop();
			}
		}
	}
}

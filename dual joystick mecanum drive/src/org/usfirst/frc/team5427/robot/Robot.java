package org.usfirst.frc.team5427.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

import org.usfirst.frc.team5427.robot.commands.ExampleCommand;
import org.usfirst.frc.team5427.robot.config.Config;
import org.usfirst.frc.team5427.robot.subsystems.ExampleSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{

	public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static OI oi;
	
	Config cfg = new Config();
	
	Joystick j = new Joystick(Config.joystickPort);
	/*
	 * Defining the four motors attached to the chassis as SteelTalons, which is
	 * a modified version of the Talon class, but includes the additional
	 * capabilities of permanently reversing the
	 * direction of the motor based on a boolean value(due to the fact that two
	 * of the gearboxes on the robot are reversed),
	 * and the ability to add offsets to the wheels while they are moving both
	 * forwards and backwards, so that they will all
	 * move at the same speed.
	 */
	public static final SteelVictor frontLeft = new SteelVictor(Config.frontLeftPort, Config.frontLeftIsReverse, Config.frontLeftBackwardOffset, Config.frontLeftForwardOffset);
	public static final SteelVictor frontRight = new SteelVictor(Config.frontRightPort, Config.frontRightIsReverse, Config.frontRightBackwardOffset, Config.frontRightForwardOffset);
	public static final SteelVictor rearLeft = new SteelVictor(Config.rearLeftPort, Config.rearLeftIsReverse, Config.rearLeftBackwardOffset, Config.rearRightBackwardOffset);
	public static final SteelVictor rearRight = new SteelVictor(Config.rearRightPort, Config.rearRightIsReverse, Config.rearRightBackwardOffset, Config.rearRightForwardOffset);
	/*
	 * defining the Digital inputs, which are used for the limit switches  
	 */
	public static final DigitalInput liftLimiter = new DigitalInput(Config.liftTop);
	public static final DigitalInput liftLimiterBottom = new DigitalInput(Config.liftBottom);
	public static final DigitalInput armsOutwardLimiter = new DigitalInput(Config.armsOut);
	public static final DigitalInput armsInwardLimiter = new DigitalInput(Config.armsIn);
	
	/*
	 * Defining the motors that both control the lift, and the arms of the
	 * robot, which are ConstantSteelTalons. ConstantSteelTalons are a modified
	 * version of
	 * a normal Talon, with the exception of the fact that they can only be set
	 * to one speed,
	 * and accepts a boolean instead of a double to control it.
	 */
	public static final LiftVictor lift = new LiftVictor(4, Config.liftSpeed, liftLimiter, liftLimiterBottom);
	public static final ArmVictor arm = new ArmVictor(5, Config.armSpeed,armsOutwardLimiter,armsInwardLimiter);
	/*
	 * Defining the RobotMaster, DriveTrain, and a Thread, which will all be
	 * used in order to create the RobotMaster
	 * Object. The RobotMaster is designed to control the DriveTrain, and both
	 * of the other motors for the lift and the arm
	 * within a thread.
	 */
	RobotMaster robo;
	DriveTrain d;
	Thread t;

	Command autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		oi = new OI();
		// instantiate the command used for the autonomous period
		autonomousCommand = new ExampleCommand();
	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		// schedule the autonomous command (example)
		if (autonomousCommand != null) autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) autonomousCommand.cancel();
		/*
		 * initializing the DriveTrain, and RobotMaster, and then adding them to
		 * a Thread.
		 */
		d = new DriveTrain(frontLeft, frontRight, rearLeft, rearRight, j);
		robo = new RobotMaster(d, j, lift, arm);
		t = new Thread(robo);
		t.start();

	}

	/*
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}

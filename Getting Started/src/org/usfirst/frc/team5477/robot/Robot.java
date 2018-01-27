package org.usfirst.frc.team5477.robot;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot
{

	private static final int kMotorPort = 0;
	private static final int kJoystickPort = 0;

	private SpeedController m_motor;
	private Joystick m_joystick;
	
	//TestEncoder Tenc = new TestEncoder();
	Encoder encoder;
	
	public void robotInit()
	{
		m_motor = new Spark(kMotorPort);
		m_joystick = new Joystick(kJoystickPort);
		encoder = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	}

	public void teleopInit()
	{
		encoder.setMaxPeriod(0.5);
		encoder.setMinRate(5);
		encoder.setDistancePerPulse(2);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(10);
	}
	
	public void teleopPeriodic() 
	{
		m_motor.set(m_joystick.getY());
		
		SmartDashboard.putNumber("Distance", encoder.getDistance());
		SmartDashboard.putNumber("Rate", encoder.getRate());
		SmartDashboard.putBoolean("Stopped", encoder.getStopped());
	}
}
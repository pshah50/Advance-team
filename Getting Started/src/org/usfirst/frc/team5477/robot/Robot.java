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
	
	//TestEncoder enc = new TestEncoder();    // Object of the TestEncoder Class to call method in tele_operated mode.
	TestEncoder enc; 
	
	Ultrasonic_I2C i2c;  // Object of the Ultrasonic_I2C class for getting distance.
	
	//Encoder encoder;
	
	public void robotInit()
	{
		m_motor = new Spark(kMotorPort);
		m_joystick = new Joystick(kJoystickPort);
		enc = new TestEncoder();
		i2c = new Ultrasonic_I2C();
		//encoder = new Encoder(0,1,false,Encoder.EncodingType.k4X);
	}

	public void teleopInit()
	{
		
	}
	
	public void teleopPeriodic() 
	{
		m_motor.set(m_joystick.getY());
		enc.encSet();
		enc.encGet();
		//i2c.getDistance();
		/*SmartDashboard.putNumber("Distance", encoder.getDistance());
		SmartDashboard.putNumber("Rate", encoder.getRate());
		SmartDashboard.putBoolean("Stopped", encoder.getStopped());*/
	}
}
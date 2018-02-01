package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedController;


public class Robot extends IterativeRobot
{

	private static final int kMotorPort = 0;
	private static final int kJoystickPort = 0;

	private SpeedController m_motor;
	private Joystick m_joystick;

	TestEncoder enc; 
		
	Ultrasonic_I2C i2c;  // Object of the Ultrasonic_I2C class for getting distance.
	
	navXMxp_Sensors navxmxp;
	
	public void robotInit()
	{
		m_motor = new Spark(kMotorPort);
		m_joystick = new Joystick(kJoystickPort);
		enc = new TestEncoder();
		i2c = new Ultrasonic_I2C();
		navxmxp = new navXMxp_Sensors();
	}

	public void teleopInit()
	{
		
	}
	
	public void teleopPeriodic() 
	{
		m_motor.set(m_joystick.getY());
		
		enc.encSet();  //set encoder values
		enc.encGet();    // Get the encoder Values.
		
		i2c.sendReq();
		
		navxmxp.getGyro();
		
		navxmxp.getAccelometer();
	}
}
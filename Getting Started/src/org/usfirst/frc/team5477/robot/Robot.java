package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;


public class Robot extends IterativeRobot
{

	//private static final int kMotorPort = 0;
	private static final int kJoystickPort = 0;

	Joystick m_joystick;
	Victor motor;
	
	NUBotX_Encoder encoder; 
		
	Ultrasonic_I2C i2c;  // Object of the Ultrasonic_I2C class for getting distance.
	
	navXMxp_Sensors navxmxp;
	
	public void robotInit()
	{
		//m_motor = new Spark(kMotorPort);
		motor =new Victor(0);
		m_joystick = new Joystick(kJoystickPort);
				
		encoder = new NUBotX_Encoder();
		i2c = new Ultrasonic_I2C();
		navxmxp = new navXMxp_Sensors();
	}

	public void teleopInit()
	{
		motor.set(1); // 1 for the forward and -1 for reverse.
	}
	
	public void teleopPeriodic() 
	{
		//m_motor.set(m_joystick.getY());
		motor.set(m_joystick.getY());
		
		encoder.encSet();  //set encoder values
		encoder.encGet();    // Get the encoder Values.
		
		
		i2c.sendReq();
		
		navxmxp.getGyro();
		
		//navxmxp.getAccelometer();
	}
}
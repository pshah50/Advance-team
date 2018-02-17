package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


public class Robot extends IterativeRobot
{
	
	//private static final int kMotorPort = 0;
	private static final int kJoystickPort = 0;
	
	Joystick m_joystick;
	Victor motor;
	
	NUBotX_Encoder encoder; 
	Ultrasonic_I2C i2c;  // Object of the Ultrasonic_I2C class for getting distance.
	navXMxp_Sensors navxmxp;
	Absolute_Encoder potentiometer;
	DigitalInput limitSwitch;
	public void robotInit()
	{
		//m_motor = new Spark(kMotorPort);
		motor =new Victor(0);
		m_joystick = new Joystick(kJoystickPort);
				
		encoder = new NUBotX_Encoder();
		
		i2c = new Ultrasonic_I2C();
		
		navxmxp = new navXMxp_Sensors();	
		
		potentiometer = new Absolute_Encoder();
		limitSwitch = new DigitalInput(5);
	}

	public void teleopInit()
	{
		motor.set(1); // 1 for the forward and -1 for reverse.
	}
	double temp;
	
	public void teleopPeriodic() 
	{
		//m_motor.set(m_joystick.getY());
				
		motor.set(m_joystick.getY());
		
		encoder.encSet();  //set encoder values
		encoder.encGet();    // Get the encoder Values.
		 		
		i2c.sendReq();
				
		navxmxp.getGyro();
		
		potentiometer.getvalue();

		
		if (potentiometer.angle > 15 && potentiometer.angle < 100)
		{
			SmartDashboard.putBoolean("Switch Value:", limitSwitch.get());
			if(limitSwitch.get()== true)
			{
				SmartDashboard.putString("Arms: ", "Goes Up");
				motor.set(m_joystick.getY());
			}
			else
			{
				SmartDashboard.putString("Arms: ", "Fold");
				motor.set(0);
			}
			
		}
		else if(potentiometer.angle >= 100)
		{
			motor.set(0);
		}
		else
		{
			//motor.set(1);
		}
		
	}
}
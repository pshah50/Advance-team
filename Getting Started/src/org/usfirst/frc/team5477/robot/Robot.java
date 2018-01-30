package org.usfirst.frc.team5477.robot;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
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
	/*I2C i2c;
	char[] CharArray;
	byte[] WriteData;   // Byte array for sending data
	byte[] ReceievData;
	boolean bool_transaction;*/
	
	//TestEncoder enc = new TestEncoder();    // Object of the TestEncoder Class to call method in tele_operated mode.
	TestEncoder enc; 
	boolean bool_address;
	
	Ultrasonic_I2C i2c;  // Object of the Ultrasonic_I2C class for getting distance.
	
	//Encoder encoder;
	
	public void robotInit()
	{
		m_motor = new Spark(kMotorPort);
		m_joystick = new Joystick(kJoystickPort);
		enc = new TestEncoder();
		//i2c = new I2C(I2C.Port.kOnboard, 84);
		i2c = new Ultrasonic_I2C();
	}

	public void teleopInit()
	{
		
	}
	
	public void teleopPeriodic() 
	{
		m_motor.set(m_joystick.getY());
		
	/*	bool_address = i2c.addressOnly();
		SmartDashboard.putBoolean("Bool address: ", bool_address);
		
		String WriteString = "go";
		char[] CharArray = WriteString.toCharArray();
		byte[] WriteData = new byte[CharArray.length];
		byte[] ReceievData = new byte[2];
		for (int i = 0; i < CharArray.length; i++) 
		{
			WriteData[i] = (byte) CharArray[i];
		}
		
		i2c.transaction(WriteData, WriteData.length, ReceievData, 0);
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		i2c.transaction(WriteData, 0, ReceievData, 2);
		String s = "";
		for (int i = 0; i < 1; i++) 
		{
			s = s + ReceievData[i];
		}
		SmartDashboard.putString("Recieve Word Number is", s);
*/
		enc.encSet();
		enc.encGet();
		i2c.sendReq();	
		//i2c.getDistance();
		/*SmartDashboard.putNumber("Distance", encoder.getDistance());
		SmartDashboard.putNumber("Rate", encoder.getRate());
		SmartDashboard.putBoolean("Stopped", encoder.getStopped());*/
	}
}
package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Ultrasonic_I2C 
{
	I2C i2c;
	char[] CharArray;
	byte[] WriteData;   // Byte array for sending data
	byte[] ReceievData;
	boolean bool_transaction;
			
	public Ultrasonic_I2C()
	{
		i2c = new I2C(I2C.Port.kOnboard, 84);
	   			 // Byte array for receiving data as distance in CM from Arduino
	}
	
	public void sendReq()
	{
		String WriteString = "go";
		CharArray = WriteString.toCharArray();
		WriteData = new byte[CharArray.length];   // Byte array for sending data
		ReceievData = new byte[2];	

		for (int i = 0; i < CharArray.length; i++) 
		{
			WriteData[i] = (byte) CharArray[i];
		}
		
		i2c.transaction(WriteData, WriteData.length, ReceievData, 0);  // Sending Data 
		
		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		i2c.transaction(WriteData, 0, ReceievData, 2);      // Get the first two byte from the data
		
		String s = " ";
		for (int i = 0; i < 1; i++)          //Use first byte only for the distance, Second byte is generally number.
		{
			s = s + ReceievData[i];
		}
		SmartDashboard.putString("Ultra Sonic Distance: ", s);
	}
}

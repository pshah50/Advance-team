package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.interfaces.Potentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Absolute_Encoder 
{
	double angle;
	
	AnalogInput ai= new AnalogInput(2);
	Potentiometer pot_encoder;
	
	public void Absolute_encoder()
	{
		angle = 0;
	}
	
	public void getvalue()
	{
		pot_encoder = new AnalogPotentiometer(ai, 360, 10);
		
		angle = pot_encoder.get();	
		SmartDashboard.putNumber("Analog Encoder", angle);
	}

}


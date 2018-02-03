package org.usfirst.frc.team5477.robot;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class NUBotX_Encoder 
{
	Encoder encoder;
	
	public NUBotX_Encoder() 
	{ 
		encoder = new Encoder(0, 1, false, EncodingType.k4X);
	}
	
	public void encReset()
	{
		encoder.reset();
	}
	
	public void encSet()
	{
		encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(7);
	}
	
	public void encGet()
	{
		SmartDashboard.putNumber("Distance", encoder.getDistance());
		SmartDashboard.putNumber("Rate", encoder.getRate());
		SmartDashboard.putBoolean("Stopped", encoder.getStopped());
		
	}
}

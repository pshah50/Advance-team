package org.usfirst.frc.team5477.robot;
 
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;;

public class navXMxp_Sensors
{
	AHRS ahrs;
	
	public void getGyro()
	{
		SmartDashboard.putNumber("Gyro Angle:",ahrs.getAngle());
		SmartDashboard.putNumber("Gyro Rate:",ahrs.getRate());
		SmartDashboard.putNumber("Gyro Raw X:",ahrs.getRawGyroX());
		SmartDashboard.putNumber("Gyro Raw Y:",ahrs.getRawGyroY());
		SmartDashboard.putNumber("Gyro Raw Z:",ahrs.getRawGyroZ());
	}
}

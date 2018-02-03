package org.usfirst.frc.team5477.robot;
 
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;;

public class navXMxp_Sensors
{
	AHRS ahrs;

	public navXMxp_Sensors()
	{
		try
		{
			ahrs = new AHRS(I2C.Port.kMXP);
		}
		catch (RuntimeException ex)
		{
			DriverStation.reportError("Error : Navx-MXP " + ex.getMessage() ,true );
		}
	}
	
	public void getGyro()
	{
		//ahrs.reset();
		double angle =0, temp=0;
		temp = ahrs.getAngle();
		
		angle = temp % 360;
		SmartDashboard.putNumber("Gyro GetAngle:", ahrs.getAngle());
		SmartDashboard.putNumber("Gyro Angle:",angle);
		SmartDashboard.putNumber("Gyro Rate:",ahrs.getRate());
		SmartDashboard.putNumber("Gyro Raw X:",ahrs.getRawGyroX());
		SmartDashboard.putNumber("Gyro Raw Y:",ahrs.getRawGyroY());
		SmartDashboard.putNumber("Gyro Raw Z:",ahrs.getRawGyroZ());
		
	}
	
	public void getAccelometer()
	{
		SmartDashboard.putNumber("NavX-MXP Accelometer X:", ahrs.getRawAccelX());
		SmartDashboard.putNumber("NavX-MXP Accelometer Y:", ahrs.getRawAccelY());
		SmartDashboard.putNumber("NavX-MXP Accelometer Z:", ahrs.getRawAccelZ());
	}
}

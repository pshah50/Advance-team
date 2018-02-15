package org.usfirst.frc.team5477.robot;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class NU_Networktabel  {
		
	NetworkTableEntry GyroActualAngle;
	NetworkTableEntry GYroAngle;
	NetworkTableEntry PotentionMeter_Angle;
	NetworkTableEntry GyroRate;
	NetworkTableEntry AccelerometerX;
	NetworkTableEntry AccelerometerY;
	NetworkTableEntry AccelerometerZ;
	NetworkTableEntry EncoderDistance;
	NetworkTableEntry EncoderRate;
	NetworkTableEntry EncoderStop;
	NetworkTableEntry UltraSonic_Distance;

	public NU_Networktabel()
	{		
		NetworkTableInstance inst = NetworkTableInstance.getDefault();
		NetworkTable table = inst.getTable("datatable");
		PotentionMeter_Angle = table.getEntry("PotentionMeter_Angle");
		GyroActualAngle = table.getEntry("GyroActualAngle");
		GYroAngle = table.getEntry("GyroAngle");
		GyroRate = table.getEntry("GyroRate");
		AccelerometerX = table.getEntry("AccelerometerX");
		AccelerometerY = table.getEntry("AccelerometerY");
		AccelerometerZ = table.getEntry("AccelerometerZ");
		EncoderDistance = table.getEntry("EncoderDistance");
		EncoderRate = table.getEntry("EncoderRate");
		EncoderStop = table.getEntry("EncoderStop");
		UltraSonic_Distance = table.getEntry("UltraSonic_Distance");
	}
	
}
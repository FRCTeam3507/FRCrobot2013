package org.usfirst.frc3507.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

public class ShooterAngler extends Subsystem{
	
	public Victor motor1;
	public Victor motor2;

	public ShooterAngler(){
		super("ShooterAngler");
		motor1 = new Victor(RobotMap.shooterAngleSlot,RobotMap.shooterAngleChannel1);
		motor2 = new Victor(RobotMap.shooterAngleSlot,RobotMap.shooterAngleChannel2);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(CommandBase.shooterAnglerState);
	}
	
}

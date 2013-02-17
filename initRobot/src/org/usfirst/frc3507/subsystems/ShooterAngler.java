package org.usfirst.frc3507.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

public class ShooterAngler extends Subsystem{
	
	public Victor motor1;
	public Victor motor2;
	DigitalInput limit;

	public ShooterAngler(){
		super("ShooterAngler");
		motor1 = new Victor(RobotMap.shooterAngleSlot,RobotMap.shooterAngleChannel1);
		motor2 = new Victor(RobotMap.shooterAngleSlot,RobotMap.shooterAngleChannel2);
		limit = new DigitalInput(RobotMap.shooterAngleSlot,RobotMap.shooterAngleLimitChannel);
	}
	
	protected void initDefaultCommand() {
		setDefaultCommand(CommandBase.shooterAnglerState);
	}
	
	//returns true if stopped
	public boolean setSpeed(double s){
		System.out.println(limit.get());
		if(!limit.get() && s > 0){
			motor1.set(0);
			motor2.set(0);
			return true;
		}
		motor1.set(s);
		motor2.set(-s);
		return false;
	}
	
}

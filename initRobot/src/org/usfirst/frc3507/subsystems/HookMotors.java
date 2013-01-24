package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HookMotors extends Subsystem {
	
	public Victor motor1;
	public Victor motor2;
	public DigitalInput Limit1;
	public DigitalInput Limit2;
	
	public HookMotors(){
		super("hook Motors");
		motor1 = new Victor(RobotMap.HookMotorSlot, RobotMap.Hook1MotorChannel);
		motor2 = new Victor(RobotMap.HookMotorSlot, RobotMap.Hook2MotorChannel);
		Limit1 = new DigitalInput(RobotMap.HookLimitSlot, RobotMap.Hook1LimitChannel);
		Limit2 = new DigitalInput(RobotMap.HookLimitSlot, RobotMap.Hook2LimitChannel);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub 
		setDefaultCommand(CommandBase.setHookSpeed);
		
	}

}

package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheels extends Subsystem {
	
	public Relay shooter = new Relay(RobotMap.shooterSlot, RobotMap.shooter1RelayChannel);
	public Relay shooter2= new Relay(RobotMap.shooterSlot, RobotMap.shooter2RelayChannel);
	
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
        setDefaultCommand(CommandBase.setShooterSpeed);		
		

	}

}

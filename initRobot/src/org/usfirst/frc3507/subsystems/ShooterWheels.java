package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheels extends Subsystem {
	
	public Relay shooter = new Relay(1,5);
	public Relay shooter2= new Relay(1,6);
	
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
        setDefaultCommand(CommandBase.setShooterSpeed);		
		

	}

}

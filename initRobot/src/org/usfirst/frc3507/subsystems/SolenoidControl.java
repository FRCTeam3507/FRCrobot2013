package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidControl extends Subsystem {

	Solenoid solenoid;
	
	public SolenoidControl(int slot, int channel){
		super("Solenoid things");
		solenoid = new Solenoid(slot,channel);
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand(CommandBase.SSS);
	}
	
	public void setState(boolean on){
		if(solenoid.get() != on){
			System.out.println("asdfasdfasdffasdfsddsd");
			solenoid.set(on);
		}
	}

}

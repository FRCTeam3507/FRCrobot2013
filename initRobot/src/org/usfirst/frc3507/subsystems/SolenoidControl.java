package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class SolenoidControl extends Subsystem {

	Solenoid solenoidA;
	Solenoid solenoidB;

	
	public SolenoidControl(){
		super("Solenoid things");
		solenoidA = new Solenoid(RobotMap.pneumaticSlot,RobotMap.pneumaticChannel1);
		solenoidB = new Solenoid(RobotMap.pneumaticSlot,RobotMap.pneumaticChannel2);
	}
	
	protected void initDefaultCommand() {
		
		setDefaultCommand(CommandBase.SSS);
	}
	
	public void setStateA(boolean on){
		if(solenoidA.get() != on){
			solenoidA.set(on);
		}
	}
	
	public void setStateB(boolean on){
		if(solenoidB.get() != on){
			solenoidB.set(on);
		}
	}

}

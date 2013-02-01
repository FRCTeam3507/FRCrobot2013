package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterWheels extends Subsystem {
	
	public Victor shooter = new Victor(RobotMap.shooterSlot, RobotMap.shooter1RelayChannel);
	public Victor shooter2= new Victor(RobotMap.shooterSlot, RobotMap.shooter2RelayChannel);
	
	public ShooterWheels(){
		super("shooter wheels");
	}
		
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
        setDefaultCommand(CommandBase.setShooterSpeed);		
		

	}
	
	public void setSpeed(double s){
		shooter.set(s);
		shooter2.set(s);
	}

}

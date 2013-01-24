package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class SetShooterSpeed extends CommandBase {

	
	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		if(oi.getButton(RobotMap.shooterJoystick,RobotMap.shooterButton)){
			
			sh1.shooter.set(Relay.Value.kForward);
			sh1.shooter2.set(Relay.Value.kForward);
			
		}
		else {
			
			sh1.shooter.set(Relay.Value.kOff);
			sh1.shooter2.set(Relay.Value.kForward);
			
		}

	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}

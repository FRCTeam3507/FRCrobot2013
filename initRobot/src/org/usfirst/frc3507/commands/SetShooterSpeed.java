package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Command;

public class SetShooterSpeed extends CommandBase {
	
	public SetShooterSpeed(){
		requires(sh1);
	}

	
	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		boolean A = oi.getButton(RobotMap.shooterController,RobotMap.shootersForwardButton);
		boolean B = oi.getButton(RobotMap.shooterController,RobotMap.shootersReverseButton);
		sh1.setSpeed(A!=B ? A ? 1 : -1 : 0);

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

package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class DiskReloadControl extends CommandBase {
	
	public DiskReloadControl(){
		requires(DRM);
		
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		DRM.setState(oi.getButton(RobotMap.reloadController, RobotMap.reloadButton));
		
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

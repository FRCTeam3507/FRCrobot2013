package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

public class SetSolenoidState extends CommandBase {
	
	public SetSolenoidState(){
		requires(SC);
	}

	protected void end() {
		// TODO Auto-generated method stub
	}

	protected void execute() {
		// TODO Auto-generated method stub
		SC.setStateA(oi.getButton(RobotMap.pneumaticController, RobotMap.pneumaticButton1));
		SC.setStateB(oi.getButton(RobotMap.pneumaticController, RobotMap.pneumaticButton2));

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

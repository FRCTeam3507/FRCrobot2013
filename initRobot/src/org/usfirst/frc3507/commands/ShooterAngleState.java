package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

public class ShooterAngleState extends CommandBase {
	

	public ShooterAngleState(){
		requires(shooterAngler);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}
	protected void execute() {
		boolean buttonUp = oi.getButton(RobotMap.shooterAngleController, RobotMap.shooterAngleButtonUp);
		boolean buttonDown = oi.getButton(RobotMap.shooterAngleController, RobotMap.shooterAngleButtonDown);
		if(buttonUp){
			shooterAngler.motor1.set(RobotMap.speed);
			shooterAngler.motor2.set(-RobotMap.speed);
		}
		else{
			shooterAngler.motor1.set(-RobotMap.speed);
			shooterAngler.motor2.set(RobotMap.speed);
		}
		
		// TODO Auto-generated method stub

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

package org.usfirst.frc3507.commands;

import edu.wpi.first.wpilibj.command.Command;

public class SetCompressorState extends CommandBase {
	
	public SetCompressorState(){
		requires(compressor);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		compressor.check();
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

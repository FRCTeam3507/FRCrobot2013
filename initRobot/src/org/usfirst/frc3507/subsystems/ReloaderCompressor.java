package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ReloaderCompressor extends Subsystem {
	
	public Compressor com = new Compressor(RobotMap.comSwitchSlot, RobotMap.comSwitchChannel, RobotMap.compressorSlot, RobotMap.compressorChannel);
	public boolean currentState = false;
	
	public ReloaderCompressor(){
		super("Compressor thingy");
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub

	}

	public void check() {
		// TODO Auto-generated method stub
		if(com.getPressureSwitchValue() != currentState){
			
			if(currentState = com.getPressureSwitchValue()) 
				com.start();
			else 
				com.stop();
		}
	}

}

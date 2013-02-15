package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ReloaderCompressor extends Subsystem {
	
	public Compressor com = new Compressor(RobotMap.comSwitchSlot, RobotMap.comSwitchChannel, RobotMap.compressorSlot, RobotMap.compressorChannel);
	public boolean currentState = false;
	private boolean started = false;
	
	public ReloaderCompressor(){
		super("Compressor thingy");
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(CommandBase.scs);
	}

	public void check() {
		if(!started){ com.start(); started = true;}
		// TODO Auto-generated method stub
		if(com.getPressureSwitchValue() != currentState){
			
			if(!(currentState = com.getPressureSwitchValue())) 
				com.setRelayValue(Relay.Value.kOn);
			else 
				com.setRelayValue(Relay.Value.kOff);
		}
	}

}

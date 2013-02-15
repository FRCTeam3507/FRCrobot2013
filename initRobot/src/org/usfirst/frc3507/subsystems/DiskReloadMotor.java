package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DiskReloadMotor extends Subsystem {
	
	Victor motor;
	DigitalInput outer;
	DigitalInput inner;
	
	boolean pressed = false;
	boolean going = false;
	boolean direction = false;
	
	public DiskReloadMotor(){
		super("disk reloader");
		motor = new Victor(RobotMap.ReloadSlot, RobotMap.ReloadChannel);
		outer = new DigitalInput(RobotMap.ReloadSlot, RobotMap.ReloadRelayChannel1);
		inner = new DigitalInput(RobotMap.ReloadSlot, RobotMap.ReloadRelayChannel2);
	}
	
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(CommandBase.DRC);
	}
	
	public void setState(boolean a){
		if(a && !pressed && !going){
			pressed = true;
			going = true;
		}
		if(!a) pressed = false;
		
		
		if(going){
			if(outer.get() && direction){
				direction = true;
				motor.set(1);
			}
			else if(inner.get() && !direction){
				direction = false;
				going = false;
				motor.set(0);
			}
			else if(direction) motor.set(-1);
			
			else motor.set(1);
			
		}
	}

}

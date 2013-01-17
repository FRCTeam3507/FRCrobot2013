package org.usfirst.frc3507.subsystems;

import org.usfirst.frc3507.commands.AutonomousAim;
import org.usfirst.frc3507.commands.CommandBase;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ImageProcessor extends Subsystem {

	public ImageProcessor(){
		super("Camera thingy");

    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        setDefaultCommand(CommandBase.AA);
    }
    public void setSpeed(double speed){

    }

}

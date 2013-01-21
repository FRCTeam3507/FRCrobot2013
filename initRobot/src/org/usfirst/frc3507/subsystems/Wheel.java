package org.usfirst.frc3507.subsystems;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc3507.commands.CommandBase;
//import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author James
 */
public class Wheel extends Subsystem {// uncomment stuff later


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    int loc;

    Victor motor;

    public Wheel(int slot,int ch,int l){
        super("Wheel");
        loc = l;
        motor = new Victor(slot, ch);
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
        
        //setDefaultCommand(new SetWheelSpeed(loc));
        setDefaultCommand(CommandBase.staticWheel);
    }
    public void setSpeed(double speed){
        motor.set(speed);
    }
}
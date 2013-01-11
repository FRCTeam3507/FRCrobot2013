package org.usfirst.frc3507.commands;


import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc3507.OI;
import org.usfirst.frc3507.RobotMap;
import org.usfirst.frc3507.subsystems.*;
 
/**
 * <p>The CommandBase class is automatically generated when the project is created.
 * However, whenever you create a new subsystem, you must create a public static
 * reference to it in the CommandBase class. All commands (except for
 * CommandGroups) should be subclasses of CommandBase.</p>
 * 
 * @author Alex Henning
 */
public abstract class CommandBase extends Command {
    // CommandBase holds a static instance of OI
    public static OI oi;
    
    // Instances of each subsystem

    public static Wheel[] wheelSet = {new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[0],0),
                        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[1],1),
                        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[2],2),
                        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[3],3)};
    

    
    public static SetWheelSpeed staticWheel = new SetWheelSpeed(0);    
   

    
    /**
     * Call this command to properly finish initializing the CommandBase.
     * This call is automatically included in the default template.
     */
    public static void init() {
        
        oi = new OI();
        

    }
    
    // Automatically created constructors.
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}

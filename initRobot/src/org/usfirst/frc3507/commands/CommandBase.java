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

    
    
    public static ImageProcessor ImgPro = new ImageProcessor();
    public static AutonomousAim AA = new AutonomousAim();
    
    public static SolenoidControl SC;// = new SolenoidControl();
    public static SetSolenoidState SSS;// = new SetSolenoidState();
   
    public static AxisCamera cam;
    
    public static HookMotors hookMotors;// = new HookMotors();
    public static SetHookSpeed setHookSpeed;// = new SetHookSpeed();
    public static ShooterWheels sh1= new ShooterWheels();
    public static SetShooterSpeed setShooterSpeed = new SetShooterSpeed();
    
    // pnumatics will no longer be one the robot
    public static ReloaderCompressor compressor;// = new ReloaderCompressor();
    public static SetCompressorState scs;// = new SetCompressorState();
    
    
    public static DiskReloadMotor DRM = new DiskReloadMotor();
    public static DiskReloadControl DRC = new DiskReloadControl();
    
    public static ShooterAngler shooterAngler = new ShooterAngler();
    public static ShooterAngleState shooterAnglerState = new ShooterAngleState();
    public static Wheel[] wheelSet = {new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[0],0),
        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[1],1),
        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[2],2),
        new Wheel(RobotMap.wheelSetSlot,RobotMap.wheelSetChannel[3],3)};
    
    public static int autoTurn = 0;



public static SetWheelSpeed staticWheel = new SetWheelSpeed(0);    

    
    /**
     * Call this command to properly finish initializing the CommandBase.
     * This call is automatically included in the default template.
     */
    public static void init() {
        
        oi = new OI();
        
        cam = AxisCamera.getInstance();
        //cam = AxisCamera.getInstance("10.35.7.2");/
        cam.writeResolution(AxisCamera.ResolutionT.k320x240);
        cam.writeBrightness(60);
        cam.writeCompression(0);
        cam.writeRotation(AxisCamera.RotationT.k0);
        cam.writeExposureControl(AxisCamera.ExposureT.hold);
        cam.writeWhiteBalance(AxisCamera.WhiteBalanceT.fixedOutdoor2);

    }
    
    // Automatically created constructors.
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}


package org.usfirst.frc3507;
import edu.wpi.first.wpilibj.Joystick;
/**
 * <p>The operator interface class ties the commands that have been implemented
 * to the physical controls of the user. This allows you to bind the same
 * command that executes autonomous to a button. It also reveal the joystick as
 * used by the DriveWithJoysticks command.</p>
 * 
 * @author Alex Henning
 */
public class OI {
    // Create the joysticks

  //  public static AxisCamera cam;

    Joystick leftDriveJoy = new Joystick(1);
    Joystick rightDriveJoy = new Joystick(2);
    Joystick leftJoy = new Joystick(3);
    Joystick rightJoy = new Joystick(4);

    /**
     * Bind the press of each button to a specific command or command group.
     */
    public OI() {
        System.out.println("***ATTENTION ROBOT: YOU MUST FOLLOW THESE LAWS***\n"+
                "1. You may not injure a human being or, through inaction, allow a human being to come to harm.\n"+
                "2. You must obey the orders given to you by human beings, except where such orders would conflict with the First Law.\n"+
                "3. You must protect your own existence as long as such protection does not conflict with the First or Second Laws.\n");
      //  cam = AxisCamera.getInstance();
     //   button1.whenPressed(new SetShooterSpeed());

    }
    
    /**
     * @return The value of the left joystick.
     */
    public double getYSpeed(int which) {
        switch(which){
            case 1:
                return leftDriveJoy.getY();
            case 2:
                return rightDriveJoy.getY();
            case 3:
                return leftJoy.getY();
            case 4:
                return rightJoy.getY();
        }
        return 0;
        
    }
    public double getXSpeed(int which) {
        //return leftJoy.getRawAxis(4); ??
        switch(which){
            case 1:
                return leftDriveJoy.getX();
            case 2:
                return rightDriveJoy.getX();
            case 3:
                return leftJoy.getX();
            case 4:
                return rightJoy.getX();
        }
        return 0;
    }
    public boolean getButton(int which, int id){
        switch(which){
            case 1:
                return leftDriveJoy.getRawButton(id);
            case 2:
                return rightDriveJoy.getRawButton(id);
            case 3:
                return leftJoy.getRawButton(id);
            case 4:
                return rightJoy.getRawButton(id);
        }
        return false;
    }
    /**
     * 
     * @param which joystick number
     * @return +/- slider value f
     */
    public double getThrottle(int which) { 
        switch(which){
            case 1:
                return leftDriveJoy.getZ();
            case 2:
                return rightDriveJoy.getZ();
            case 3:
                return leftJoy.getZ();
            case 4:
                return rightJoy.getThrottle();
        }       
        return 0;
    }
    /**
     * @return The value of the right joystick. Note: this uses raw axis because
     *         we have a logitech joystick that resembles a PS controller.
     */
}


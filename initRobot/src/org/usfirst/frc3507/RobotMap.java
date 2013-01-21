package org.usfirst.frc3507;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // Motors: This is the mapping of motors ports marked PWM on the DIO board
    /*public static final int
            shooterSlot = 1, 
            wheelSetSlot = 1,
            motorSetSlot = 1;

    // Shooter Map
    public static final int
            shooterLChannel = 5,
            shooterRChannel = 6,
            autoTopButton = 1,
            autoMiddleButton = 2,
            shooterSpeedJoy = 4,
            shooterAimJoy = 1,
            autoShooterSpeedToggle = 2,
            lowerShooter = 3,
            raiseShooter = 5,
            shooterElevatorChannel = 3,
            shooterLowerLimit = 9,
            shooterUpperLimit = 10,
            shooterEncoder1 = 1,
            shooterEncoder2 = 2;
    
    // Conveyor Map
    public static final int
            conveyorChannel = 7,
            conveyorJoy = 3,
            conveyorDirectionToggle = 8,
            conveyorStatusToggle = 9,
            rollerChannel = 4,
            conveyorSlot = 1; 
    
    // Bridge lowerer map
    public static final int
            bridgeRelayChannel = 2,
            bridgeSlot = 1,
            bridgeJoy = 2,
            bridgeActivateButton = 1,
            bridgeToggleModeButton = 6,
            bridgeRaiseButton = 3,
            bridgeLowerButton = 2,
            bridgeLowerLimit = 5,
            bridgeUpperLimit = 6;*/
    
    public static final int[]
            wheelSetChannel = new int[]{1,2,3,4};
    
    public static final int
    // slots
    	wheelSetSlot = 1,
    	pneumaticSlot = 2,
    	
    //channels
    	pneumaticChannel1 = 1,
    	pneumaticChannel2 = 2,
    	
    //buttons
    	CameraTestingButton = 2,
    	pneumaticButton1 = 4,
    	pneumaticButton2 = 5,
    
    //controller numbers
    	CameraTestingController = 2,
    	pneumaticController = 2;
    /*
     * wheel numbers
     *
     * front (conveyor)
     * 1 | 2
     * - + -
     * 3 | 4
     * back (bridge lowerer)
     *
     */
     public static final double
             wheelSpeedEdit = 1.0;

}

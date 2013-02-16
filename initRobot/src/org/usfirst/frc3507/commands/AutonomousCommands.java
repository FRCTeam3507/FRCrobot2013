package org.usfirst.frc3507.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class AutonomousCommands extends CommandGroup {
	public AutonomousCommands() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
        addSequential(new AutonomousShooterAngle());
        addSequential(new AutonomousShooting());
        
        //needs conveyer belt
         
        
        //moves backwards (currently 1 foot)
       // addSequential(new AutonomousDriveBackDistance(12));
        
        // addSequential(new AutonomousDriveBackDistance(95)); // actual lenght to travel
        // addSequential(new AutonomousBridgeArm()); //lowers bridge arm until it reacheslimit
    }
}

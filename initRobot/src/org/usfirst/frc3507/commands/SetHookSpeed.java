package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class SetHookSpeed extends CommandBase {
	
	public SetHookSpeed(){
		requires(hookMotors);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}

	protected void execute() {
		// TODO Auto-generated method stub
		double speed = scale(oi.getXSpeed(RobotMap.HookController));
		if(speed > 0 && !hookMotors.Limit1.get()){
			hookMotors.motor1.set(speed);
		}
		else if(speed < 0 && !hookMotors.Limit2.get()){
			hookMotors.motor2.set(-speed);
		}
	}

	protected void initialize() {
		// TODO Auto-generated method stub

	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public double scale(double i){
        if(i>0){
            i = (i-0.1)*10.0/9.0;
            if(i < 0)
                i = 0;
        }
        else if(i<0){
            i = (i+0.1)*10.0/9.0;
            if(i > 0)
                i = 0;
        }
        return i;
    }

}

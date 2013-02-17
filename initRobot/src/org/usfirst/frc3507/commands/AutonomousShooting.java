package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

public class AutonomousShooting extends CommandBase {
	
	public int disksShot = 0;
	public int disksToShoot = 3;
	public long ActionStartTime = 0;
	public long ActionEndTime = 0;
	public int stage = 0;
	
	public AutonomousShooting(){
		requires(sh1);
		requires(DRM);
	}

	protected void end() {
		// TODO Auto-generated method stub
		sh1.setSpeed(0);
		stop();
	}

	protected void execute() {
		// TODO Auto-generated method stub
		switch(stage){
			case 0://init
				setNextTime(3000);
				stage = 1;
				break;
				
			case 1://allow speedup, wait
				if(timeEnd()){
					setNextTime(100);
					stage = 2;
					load();
				}
				break;
				
			case 2://load
				if(timeEnd()){
					setNextTime(800);
					stage = 3;
					stop();
				}
				break;
				
			case 3://wait
				if(timeEnd()){
					setNextTime(100);
					stage = 4;
					shoot();
				}
				break;
				
			case 4://shoot
				if(timeEnd()){
					setNextTime(800);
					stage = 1;
					stop();
					disksShot++;
				}
				break;
		}
	}
	public void load(){
		DRM.setStuff(-RobotMap.DiskReloadSpeed );
	}
	
	public void shoot(){
		DRM.setStuff(RobotMap.DiskReloadSpeed );
	}
	
	public void stop(){
		DRM.setStuff(0);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
		sh1.setSpeed(RobotMap.shooterSpeed);
	}

	protected void interrupted() {
		// TODO Auto-generated method stub

	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return disksShot >= disksToShoot;
	}
	
	public void setNextTime(long millis){
		ActionStartTime = System.currentTimeMillis();
		ActionEndTime = ActionStartTime + millis;
	}
	public boolean timeEnd(){
		return ActionStartTime >= ActionEndTime;
	}

}

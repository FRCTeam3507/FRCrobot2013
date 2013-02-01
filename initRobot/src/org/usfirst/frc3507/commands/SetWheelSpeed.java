package org.usfirst.frc3507.commands;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc3507.RobotMap;


/**
 *
 * @author James
 */
public class SetWheelSpeed extends CommandBase {
    int ch;//location in the array
    public SetWheelSpeed(int i) {
    	
     //   requires(wheelSet[i]);
        requires(wheelSet[0]);
        requires(wheelSet[1]);
        requires(wheelSet[2]);
        requires(wheelSet[3]);
        ch = i;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
        
        /*if (oi.getButton(RobotMap.shooterAimJoy, RobotMap.autoTopButton))
        {
            double[] sets = new double[4];
            try {
                sets = ImageProcessor.getWheelMovement(ImageProcessor.getTopCorners(CommandBase.cam.getImage()));
            } catch (AxisCameraException ex) {
                String exe=ex.getMessage();
                SmartDashboard.putString("Camera Error", exe);
            } catch (NIVisionException ex) {
                String exe=ex.getMessage();
                SmartDashboard.putString("Camera Error", exe);
            }
//            wheelSet[0].setSpeed(sets[0]);
//            SmartDashboard.putDouble("Wheel set 0", sets[0]);
//            wheelSet[1].setSpeed(sets[1]);
//            SmartDashboard.putDouble("Wheel set 1", sets[1]);
//            wheelSet[2].setSpeed(sets[2]);
//            SmartDashboard.putDouble("Wheel set 2", sets[2]);
//            wheelSet[3].setSpeed(sets[3]);
//            SmartDashboard.putDouble("Wheel set 3", sets[3]);
            for(int i = 0; i < 4; i++){
                wheelSet[i].setSpeed(sets[i]);
            }
        
        }
        else {*/

            double X = oi.getXSpeed(1);
            double Y = oi.getYSpeed(1);
            double rotation = -oi.getXSpeed(2);

            X = scale(X);
            Y = scale(Y);
            rotation = scale(rotation);



            /*double[] speeds = new double[]{
                Y
               +X
               +rotation*RobotMap.wheelSpeedEdit
                        ,
                Y
               -X
               -rotation*RobotMap.wheelSpeedEdit
                        ,
               Y
               -X
               +rotation*RobotMap.wheelSpeedEdit
                        ,
               Y
               +X
               -rotation*RobotMap.wheelSpeedEdit

            };*/
            
            double[] speeds = new double[]{
                Y
               +X
               +rotation*RobotMap.wheelSpeedEdit
                        ,
                Y
               -X
               -rotation*RobotMap.wheelSpeedEdit
                        ,
               Y
               -X
               +rotation*RobotMap.wheelSpeedEdit
                        ,
               Y
               +X
               -rotation*RobotMap.wheelSpeedEdit

            };
            
            double max = maxOfArray(speeds);

            //- - - - - - - - - - - - - - - - - - 
    //        for(int i = 0; i < speeds.length;i++){
    //            speeds[i] -= speeds[i]%(0.01);
    //        }

            //- - - - - - - - - - - - - - - - - -
            max = (max-0.1)*10.0/9.0;
            if(max<0.0){
                max = 0.0;
            }
            if(max>0.0&&max<1.0){
                max = 1.0;
            }
            speeds[1]=-speeds[1];
            speeds[3]=-speeds[3];
            if(max!=0.0){
                for(int i = 0; i < 4; i++){
                    wheelSet[i].setSpeed(speeds[i]/max);
                }
               // wheelSet[ch].setSpeed(speeds[ch]/max);
            }
            else{
                for(int i = 0; i < 4; i++){
                    wheelSet[i].setSpeed(0);
                }
                //wheelSet[ch].setSpeed(0);
            }
        //}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
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
    public double maxOfArray(double[] A){
        double max = 0;
        for(int i = 0; i < A.length; i++){
            //A[i] = abs(A[i]);
            if(abs(A[i])>max){
                 max = abs(A[i]);
            }
        }
        return max;
    }
    public double abs(double i){
        if(i<0)
            return -i;
        return i;
    }
    
}
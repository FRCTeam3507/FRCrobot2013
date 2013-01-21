package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

public class AutonomousAim extends CommandBase {

    boolean done = false;
    public AutonomousAim() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(wheelSet[0]);
        requires(wheelSet[1]);
        requires(wheelSet[2]);
        requires(wheelSet[3]);
        requires(ImgPro);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    public int weAreHere = 0;
    protected void execute() {
    	if(weAreHere++ > 100){
    		System.out.print("WeAreHere");
    		weAreHere = 0;
    	}
    	if(!oi.getButton(RobotMap.CameraTestingController, RobotMap.CameraTestingButton))return;
    	System.out.println("PRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSED");
        try {
        	ColorImage img = CommandBase.cam.getImage();
            BinaryImage biImg = img.thresholdRGB(100, 255, 100, 255, 100, 255); 
            CriteriaCollection m = new CriteriaCollection();
            
            //m.addCriteria(NIVision.MeasurementType.IMAQ_MT_NUMBER_OF_HORIZ_SEGMENTS,15,999,false);
            //m.addCriteria(NIVision.MeasurementType.IMAQ_MT_NUMBER_OF_VERT_SEGMENTS,15,999,false);
            
            //m.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 30, 400, false);
            //m.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
            
            //to try
            //IMAQ_MT_CONVEX_HULL_AREA 
            //IMAQ_MT_CONVEX_HULL_PERIMETER 
            
            //maybe subtract this
            //IMAQ_MT_NUMBER_OF_HOLES 
            
            
            biImg.particleFilter(m);
            ParticleAnalysisReport[] array = biImg.getOrderedParticleAnalysisReports();
           
            
            
            System.out.println(biImg.getNumberParticles());
            
            boolean[][] boolImg = new boolean[array[0].imageWidth][array[0].imageHeight];
           
            int size = biImg.image.getSize();
            System.out.println("Array Size "+array.length);
            System.out.println("Size "+size);
            System.out.println("Size2 "+img.image.getSize());
            System.out.println("Size bool "+img.image.isValid());
            
           /* 
            *       
            cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
            cc.addCriteria(NIVision.MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 40, 400, false);
            *  BinaryImage convexHull = largeObjects.convexHull(false);
            BinaryImage filtered = convexHull.particleFilter(cc);


            * for(int x = 0; x < boolImg.length; x++){
                for(int y = 0; y < boolImg[0].length; y++){
                    boolImg[x][y] = (biImg.image.getInt(x+y*boolImg.length)>0);
                }   
            }*/
            
            
            
            
             for(int i = 0; i < array.length; i++){
                for(int x = array[i].boundingRectLeft ;
                        x < array[i].boundingRectLeft+array[i].boundingRectWidth ;
                        x++){
                    for(int y = array[i].boundingRectTop ;
                            y < array[i].boundingRectTop+array[i].boundingRectHeight ;
                            y++){
                        boolImg[x][y] = true;
                    }
                }
            }
            
            for(int y = 115; y < 163; y++){
                 for(int x = 25; x < 85; x++){
                
                    if(boolImg[x][y]){
                        System.out.print("X");
                    }
                    else
                        System.out.print(" ");
                }
                System.out.println();
            }
        } catch (AxisCameraException ex) {
        } catch (NIVisionException ex) {
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        for(int i = 0; i < 4; i++){
            wheelSet[i].setSpeed(0);

        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }

}

package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

import java.lang.Math;

public class ShooterAngleState extends CommandBase {
	
	CriteriaCollection cc;
	public ShooterAngleState(){
		requires(shooterAngler);
		cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);
	}

	protected void end() {
		// TODO Auto-generated method stub

	}
	protected void execute() {

		if(oi.getButton(RobotMap.shooterAngleController, RobotMap.shooterAngleAutoButton)){
			autonomous();
		}
		else{
			boolean buttonUp = oi.getButton(RobotMap.shooterAngleController, RobotMap.shooterAngleButtonUp);
			boolean buttonDown = oi.getButton(RobotMap.shooterAngleController, RobotMap.shooterAngleButtonDown);
			if(buttonUp != buttonDown){
				if(buttonUp)
					moveUp();
			
				else
					moveDown();
				
			}
			else
				stopMove();
			
		}
		
		// TODO Auto-generated method stub

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
	
	public void moveUp(){
		shooterAngler.setSpeed(RobotMap.speed);
	}
	
	public void moveDown(){
		shooterAngler.setSpeed(RobotMap.lowerSpeed);
	}
	
	public void stopMove(){
		shooterAngler.setSpeed(0);
	}


    public void autonomous()  {
        
        try {
            /**
             * Do the image capture with the camera and apply the algorithm described above. This
             * sample will either get images from the camera or from an image file stored in the top
             * level directory in the flash memory on the cRIO. The file name in this case is "testImage.jpg"
             * 
             */
            ColorImage image = cam.getImage();     // comment if using stored images
            //ColorImage image;                           // next 2 lines read image from flash on cRIO
         //   image = new RGBImage("/testImage.jpg");		// get the sample image from the cRIO flash
            BinaryImage thresholdImage = image.thresholdHSV(60, 100, 90, 255, 20, 255);   // keep only red objects
            //thresholdImage.write("/threshold.bmp");
            BinaryImage convexHullImage = thresholdImage.convexHull(false);          // fill in occluded rectangles
            //convexHullImage.write("/convexHull.bmp");
            BinaryImage filteredImage = convexHullImage.particleFilter(cc);           // filter out small particles
            //filteredImage.write("/filteredImage.bmp");
            
            ParticleAnalysisReport[] par = filteredImage.getOrderedParticleAnalysisReports();
            double[] target = new double[]{image.getWidth()/2.0, image.getHeight()};
            
            double minDist = -1;
            double[] minMid = new double[0];
            
            //calculate closest rectangle
            for(int i = 0; i < par.length; i++){
            	ParticleAnalysisReport p = par[i];
            	double[] mid = new double[]{p.boundingRectLeft + p.boundingRectWidth/2.0, p.boundingRectTop + p.boundingRectHeight/2.0};
            	double dist = Math.sqrt((mid[0]-target[0])*(mid[0]-target[0])+(mid[1]-target[1])*(mid[1]-target[1]));
            	if(minDist == -1 || minDist > dist){
            		minDist = dist;
            		minMid = mid;
            	}
            }
            
            if(minDist != -1){
            	if(minMid[1] > target[1] + RobotMap.errorMargin) moveDown();
            	else if(minMid[1] < target[1] - RobotMap.errorMargin) moveUp();
            	else stopMove();
            	if(minMid[0] > target[0] + RobotMap.errorMargin) autoTurn = 1;
            	else if(minMid[0] < target[0] - RobotMap.errorMargin) autoTurn = -1;
            	else autoTurn = 0;
            }
            else stopMove();
            
            
            filteredImage.free();
            convexHullImage.free();
            thresholdImage.free();
            image.free();
            
//	            } catch (AxisCameraException ex) {        // this is needed if the camera.getImage() is called
//	                ex.printStackTrace();
        } catch (NIVisionException ex) {
            ex.printStackTrace();
        } catch (AxisCameraException ace){
        	ace.printStackTrace();
        }
    }
	    

	 

}

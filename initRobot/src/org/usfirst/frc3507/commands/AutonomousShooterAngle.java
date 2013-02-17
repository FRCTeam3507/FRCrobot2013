package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;

public class AutonomousShooterAngle extends CommandBase {

	CriteriaCollection cc;
	public boolean done = false;
	private boolean stopped1 = false;
	private boolean stopped2 = false;
	public AutonomousShooterAngle(){
		requires(wheelSet[0]);
        requires(wheelSet[1]);
        requires(wheelSet[2]);
        requires(wheelSet[3]);
		requires(shooterAngler);
		cc = new CriteriaCollection();      // create the criteria for the particle filter
        cc.addCriteria(MeasurementType.IMAQ_MT_AREA, 500, 65535, false);
	}

	protected void end() {
		// TODO Auto-generated method stub
		turnStop();
		stopMove();

	}
	protected void execute() {

		autonomous();

		
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
		return done;
	}
	
	public void moveUp(){
		
		stopped1 = shooterAngler.setSpeed(RobotMap.speed);
	}
	
	public void moveDown(){
		
		stopped1 = shooterAngler.setSpeed(RobotMap.lowerSpeed);
	}
	
	public void stopMove(){
		
		stopped1 = shooterAngler.setSpeed(0);
	}
	
	public void turnLeft(){
		double [] speeds = new double[]{RobotMap.wheelSpeedEdit,-RobotMap.wheelSpeedEdit,RobotMap.wheelSpeedEdit,-RobotMap.wheelSpeedEdit};
		
		for(int i = 0; i < 4; i++){ 
			wheelSet[i].setSpeed(speeds[i]); 
		}
		stopped2 = false;
	}
	
	public void turnRight(){
		double[] speeds = new double[]{-RobotMap.wheelSpeedEdit,RobotMap.wheelSpeedEdit,-RobotMap.wheelSpeedEdit,RobotMap.wheelSpeedEdit};
		        
		for(int i = 0; i < 4; i++){ 
			wheelSet[i].setSpeed(speeds[i]); 
		}
		stopped2 = false;
	}
	
	public void turnStop(){
		for(int i = 0; i < 4; i++){ 
			wheelSet[i].setSpeed(0); 
		}
		stopped1 = true;
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
            if(par.length == 0){
            	done = true;
            	return;
            }
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
            	if(minMid[0] > target[0] + RobotMap.errorMargin) turnRight();
            	else if(minMid[0] < target[0] - RobotMap.errorMargin) turnLeft();
            	else turnStop();
            	if(stopped1 && stopped2){
            		done = true;
            		return;
            	}
            }
            else{
            	done = true;
        		return;
            }
            
            
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

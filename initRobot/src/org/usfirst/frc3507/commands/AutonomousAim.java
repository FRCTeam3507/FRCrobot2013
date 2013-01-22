package org.usfirst.frc3507.commands;

import org.usfirst.frc3507.RobotMap;

import com.sun.cldc.jna.Pointer;

import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;
import java.lang.Integer;

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
    	if(weAreHere++ > 1000){
    		System.out.print("WeAreHere");
    		weAreHere = 0;
    	}
    	if(!oi.getButton(RobotMap.CameraTestingController, RobotMap.CameraTestingButton))return;
    	System.out.println("PRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSEDPRESSED");
        try {
        	
        	ColorImage img = CommandBase.cam.getImage();
        	//BinaryImage img = img2.thresholdRGB(100, 255, 100, 255, 100, 255); 
        	Pointer po = img.image.align(0);
        	
        	//System.out.println(img.image.getSize());
        	//System.out.println(img.getWidth());
        	//System.out.println(img.image);
        	System.out.println(po.getSize()/24);
        	
        	int[] ints = new int[po.getSize()/24];
        	img.image.getInts(0, ints, 0, (po.getSize()/24)-100);
        	
        	

        	
        	
        	for(int i = 0; i < ints.length; i++){
        		System.out.print(Integer.toHexString(ints[i]) + " ");
        	}
        	System.out.println("\n");
        	for(int i = 0; i < ints.length; i++){
        		
        		int test = (((ints[i]>>16)&0xff) + ((ints[i]>>8)&0xff) + ((ints[i])&0xff))/3;
        		if(test <=  51)
        			System.out.print("\u2588");
        		else if(test <=  102)
        			System.out.print("\u2593");
        		else if(test <=  153)
        			System.out.print("\u2592");
        		else if(test <=  204)
        			System.out.print("\u2591");
        		else
        			System.out.print("_");
        		
        		if((i+1)%img.getWidth() == 0)System.out.println();
        	}
        	//shades for testing
        	//255 - 205 avg = 
        	//204 - 154 avg =  \u2591
        	//153 - 103 avg =  \u2592
        	//102 - 52 avg 	=  \u2593
        	//51 - 0 avg 	=  \u2588
        	
            BinaryImage biImg = img.thresholdRGB(100, 255, 100, 255, 100, 255); 
            CriteriaCollection m = new CriteriaCollection();
            
            //m.addCriteria(NIVision.MeasurementType.IMAQ_MT_NUMBER_OF_HORIZ_SEGMENTS,15,999,false);
            //m.addCriteria(NIVision.MeasurementType.IMAQ_MT_NUMBER_OF_VERT_SEGMENTS,15,999,false);
            
            m.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_HEIGHT, 30, 400, false);
            m.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
            
            //to try
            //IMAQ_MT_CONVEX_HULL_AREA 
            //IMAQ_MT_CONVEX_HULL_PERIMETER 
            
            //maybe subtract this
            //IMAQ_MT_NUMBER_OF_HOLES 
            
            
            biImg.particleFilter(m);
            ParticleAnalysisReport[] array = biImg.getOrderedParticleAnalysisReports();
           
            
            
            System.out.println(biImg.getNumberParticles());
            
            //boolean[][] boolImg = new boolean[array[0].imageWidth][array[0].imageHeight];
           
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
            
            
            
            
            /* for(int i = 0; i < array.length; i++){
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
            }*/
        } catch (AxisCameraException ex) {
        	System.out.println("ERROR HERE");
        } catch (NIVisionException ex) {
        	System.out.println("ERROR THERE");
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

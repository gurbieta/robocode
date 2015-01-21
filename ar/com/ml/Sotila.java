package ar.com.ml;
import java.awt.Color;

import robocode.*;
//import java.awt.Color;

// API help : http://robocode.sourceforge.net/docs/robocode/robocode/Robot.html

/**
 * Sotila - a robot by (your name here)
 */
public class Sotila extends Robot
{
	/**
	 * run: Sotila's default behavior
	 */
	public void run() {
		
		setColors(Color.black, Color.black, Color.black, Color.yellow, Color.cyan);
		
		// Robot main loop
		while(true) {
			turnRadarRight(360);
		}
	}

	@Override
	public void onBulletHit(BulletHitEvent event) {
		fire(5);
	}

	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		turnLeft(event.getBearing());
		ahead(100);
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		if(event.isMyFault()){
			fire(10);
		}else{
			turnRight(15);
			ahead(50);
		}
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		turnRight(-event.getBearing());
		ahead(50);
	}

	@Override
	public void onScannedRobot(ScannedRobotEvent event) {
		turnRight(event.getBearing());
		if(event.getDistance() < 100){
			fire(10);
		}else if(event.getDistance() < 250){
			fire(5);
		}else if(event.getDistance() < 500){
			fire(1);
		}else{
			ahead(20);
		}
	}

}

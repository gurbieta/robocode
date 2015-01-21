package mshops.ballerini;

import robocode.BulletHitBulletEvent;
import robocode.BulletHitEvent;
import robocode.BulletMissedEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * @author gurbieta
 * @date Jan 21, 2015
 */
public class Dany extends Robot {

	

	public void run() {
		while (true) {
			ahead(100);
			turnGunRight(40);
			turnRight(3);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		if (e.getDistance() < 100) {
			fire(15);
		}else if(e.getDistance() < 300){
			fire(5);
		}
		fire(1);
	}

	@Override
	public void onBulletHit(BulletHitEvent event) {
		fire(event.getEnergy() + 1);

	}

	@Override
	public void onBulletMissed(BulletMissedEvent event) {
		turnLeft(90);
		ahead(100);
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		fire(event.getEnergy() + 1);
	}

	@Override
	public void onBulletHitBullet(BulletHitBulletEvent event) {
		fire(10);
	}

	
	@Override
	public void onHitWall(HitWallEvent event) {
		turnLeft(event.getBearing()+90);
	}
}

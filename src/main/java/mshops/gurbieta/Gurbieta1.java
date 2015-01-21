package mshops.gurbieta;

import java.util.HashMap;
import java.util.Map;

import robocode.BulletHitEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;
import robocode.HitWallEvent;
import robocode.Robot;
import robocode.Rules;
import robocode.ScannedRobotEvent;
import robocode.control.events.TurnStartedEvent;

/**
 * @author gurbieta
 * @date Jan 21, 2015
 */
public class Gurbieta1 extends Robot {

	Map<String, String>	name	= new HashMap<String, String>();

	public void run() {
		while (true) {
			ahead(50);
			turnRight(60);
			turnGunRight(60);
			ahead(50);
			turnLeft(90);
			turnGunLeft(60);
			
			// turnRadarLeft(360);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		double energy = e.getEnergy();

		double velocity = e.getVelocity();

		double distance = e.getDistance();

		double firePower;

		if (distance < 500) {
			firePower = Rules.MAX_BULLET_POWER;
		} else if (distance < 1000) {
			firePower = Rules.MAX_BULLET_POWER / 2;
		} else {
			firePower = 1;
		}

		fire(firePower);
	}

	@Override
	public void onBulletHit(BulletHitEvent event) {
		// TODO Auto-generated method stub
		super.onBulletHit(event);
		// TODO: le pegamos
	}

	@Override
	public void onHitWall(HitWallEvent event) {
		
		if (event.getBearing() > 0) {
			turnLeft(-180);
		} else {
			turnLeft(180);
		}
	}

	@Override
	public void onHitRobot(HitRobotEvent event) {
		// TODO Auto-generated method stub
		super.onHitRobot(event);

		// TODO: posicionar cañón y hacerlo crema
	}

	@Override
	public void onHitByBullet(HitByBulletEvent event) {
		// TODO Auto-generated method stub
		super.onHitByBullet(event);

		// TODO: RAJAR
	}

}

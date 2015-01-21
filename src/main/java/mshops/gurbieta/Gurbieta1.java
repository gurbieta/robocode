package mshops.gurbieta;

import robocode.Robot;
import robocode.ScannedRobotEvent;

/**
 * @author gurbieta
 * @date Jan 21, 2015
 */
public class Gurbieta1 extends Robot {
	
	public void run() {
        while (true) {
            ahead(100);
            turnGunRight(360);
            back(100);
            turnGunRight(360);
        }
    }
 
    public void onScannedRobot(ScannedRobotEvent e) {
        fire(1);
    }
    
}

package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import element.Obstacle;
import element.Posture;

public class ObstacleTest {

	@Test
	public void testObstacle() {
		Posture pos = new Posture(0,0,0);
		int diametre=10;
		Obstacle obst = new Obstacle(pos,diametre);
		assertEquals(diametre,obst.getDiametre(),0);
		assertEquals(pos.getX(), obst.getPos().getX(),0);
		assertEquals(pos.getY(), obst.getPos().getY(),0);
		assertEquals(pos.getTheta(), obst.getPos().getTheta(),0);	
	}

}

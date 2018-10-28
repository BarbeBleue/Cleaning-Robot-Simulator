package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import element.Mur;
import element.Posture;

public class MurTest {

	@Test
	public void testMur() {
		Posture pos = new Posture(0,0,0);
		int lar=10;
		int lon=20;
		Mur mur = new Mur(pos,lar,lon);
		assertEquals(lar, mur.getLargeur(),0);
		assertEquals(lon, mur.getLongueur(),0);
		assertEquals(pos.getX(), mur.getPos().getX(),0);
		assertEquals(pos.getY(), mur.getPos().getY(),0);
		assertEquals(pos.getTheta(), mur.getPos().getTheta(),0);	
	}

}

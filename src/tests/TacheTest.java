package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import element.Posture;
import element.Tache;

public class TacheTest {

	@Test
	public void testTache() {
		Posture pos = new Posture(0,0,0);
		int diametre=10;
		Tache tache = new Tache(pos,diametre);
		assertEquals(diametre, tache.getDiametre(),0);
		assertEquals(pos.getX(), tache.getPos().getX(),0);
		assertEquals(pos.getY(), tache.getPos().getY(),0);
		assertEquals(pos.getTheta(), tache.getPos().getTheta(),0);	
	}

}

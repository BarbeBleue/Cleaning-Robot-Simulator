package forme;

import graphique.*;
import element.*;
import robot.*;

/**
 * Classe d'une Forme 
 * @author Maeva ARLANDIS et Amelie EUGENE
 *
 */
public abstract class Forme {
	
	//constructeur
	/**
	 * Constructeur par defaut
	 */
	public Forme() {
	}
	
	//methodes
	/** isColliding retourne vrai si le Roomba designe par robot et dans la posture pos est en collision
	 * avec la forme.
	 * @param robot le Robot en question, post posture a tester.
	 * @param pos_robot la Posture du robot
	 * @param pos_elem la Posture de l'element
	 * @return True si il y a collision et false sinon
	 */
	public abstract boolean isColliding(Roomba robot, Posture pos_robot, Posture pos_elem);

	public abstract boolean collide (Capteur cap, Posture pos_elem);
	
	public abstract int getHomogeneousSize();
	
	public abstract String toString();
	
	public abstract void paint(Graphique g, Posture pos);
	
}

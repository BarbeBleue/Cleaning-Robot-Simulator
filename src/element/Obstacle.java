package element;

import forme.*;
import graphique.Graphique;

/**
 * Classe d'un Obstacle de forme ronde qui h�rite de la classe Element
 * @author Maeva ARLANDIS et Amelie EUGENE
 *
 */

public class Obstacle extends Element {

	//constructeur
	/**
	 * Constructeur d'un Obstable rond avec une posture et un diametre definis
	 * @param pos La posture voulue
	 * @param diametre Le diametre voulu
	 */
	public Obstacle(Posture pos, int diametre) {
		super(pos, new Cercle(diametre));
	}
	
	//methodes
	
	/**
	 * Permet d'obtenir le diametre de l'obstacle
	 * @return Le diametre de l'obstacle
	 */
	public int getDiametre() {
		Cercle c = (Cercle) this.getForme();
		return c.getDiametre();
	}
	
	/**
	 * Permet de savoir si un obstacle est nettoyable
	 * @return Renvoie false puisqu'un obstacle n'est jamais nettoyable
	 */
	public boolean isCleanable() {
		return false;
	}	
	
	/**
	 * Methode d'affichage
	 * @return String
	 */
	public String toString() {return "Obstacle de " + this.getForme() + " � la position " + this.getPos();}

	/**
	 * Methode permetant de modifier l'interface graphique
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g) {
		g.draw(this);
	}
}

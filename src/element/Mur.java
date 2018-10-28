package element;

import forme.*;
import graphique.*;

/**
 * Classe d'un Mur de forme rectangulaire qui h�rite de la classe Element
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Mur extends Element {

	//constructeur
	/**
	 * Constructeur d'un mur de forme rectangulaire d'une largeur et longueur fix�es avec une posture voulu 
	 * @param pos La posture voulue
	 * @param lar La largeur du mur
	 * @param lon La longueur du mur
	 */
	
	public Mur(Posture pos, int lar, int lon) {
		super(pos, new Rectangle(lar,lon));
	}
	
	//methodes
	
	/**
	 * Permet d'obtenir la largeur du mur
	 * @return La largeur du mur
	 */
	public int getLargeur() {
		Rectangle r=(Rectangle) this.getForme();
		return r.getLargeur();
	}
	
	/**
	 * Permet d'obtenir la longueur du mur
	 * @return La longuur du mur
	 */
	public int getLongueur() {
		Rectangle r=(Rectangle) this.getForme();
		return r.getLongueur();
	}
	
	/**
	 * Permet de savoir si un mur est nettoyable
	 * @return Renvoie false puisqu'un mur n'est jamais nettoyable
	 */
	public boolean isCleanable() {
		return false;
	}	
	
	/**
	 * Methode d'affichage
	 * @return String
	 */
	public String toString() {return "Mur de " + this.getForme() + " � la position " + this.getPos();}
	
	/**
	 * Methode permetant de modifier l'interface graphique
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g) {
		g.draw(this);
	}
	

}

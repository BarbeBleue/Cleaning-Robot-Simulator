package element;

import forme.*;
import graphique.Graphique;

/**
 * Classe d'une Tache de forme ronde qui h�rite de la classe Element
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Tache extends Element{

	//constructeur
	/**
	 * Constructeur d'une Tache ronde de diametre et posture fix�es
	 * @param pos La posture voulue
	 * @param diametre Le diametre voulu
	 */
	public Tache(Posture pos, int diametre) {
		super(pos, new Cercle(diametre));
	}
	
	//methodes
	
	/**
	 * Permet d'obtenir le diametre de la tache
	 * @return Le diametre de la Tache
	 */
	public int getDiametre() {
		Cercle c = (Cercle) this.getForme();
		return c.getDiametre();
	}
	
	/**
	 * Permet de savoir si une tache est nettoyable
	 * @return Renvoie true puisqu'une tache est toujours nettoyable
	 */
	public boolean isCleanable() {
		return true;
	}
	
	/**
	 * Methode de modification de l'interface graphique
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g) {
		g.draw(this);
	}
	
	/**
	 * Methode d'affichage
	 * @return String
	 */
	public String toString() {return "Tache de " + this.getForme() + " � la position " + this.getPos();}

}

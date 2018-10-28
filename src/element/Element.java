package element;

import graphique.*;
import forme.*;
import robot.*;

/**
 * Classe d'un Element qui peut etre contenu dans un Environnement avec une position et une forme
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public abstract class Element {

	//attributs
	protected Posture pos;
	private Forme forme;
		
	//constructeurs
	/**
	 * Constructeur par defaut d'un Element
	 */
	public Element() {
		this.pos=new Posture(0,0,0);
	}
	
	/**
	 * Constructeur d'un Element de forme choisi 
	 * @param forme La forme voulue de l'Element
	 */
	public Element(Forme forme) {
		this.forme=forme;
		this.pos= new Posture(0,0,0);
	}
	
	/**
	 * Constructeur d'un Element de forme et posture choisie
	 * @param pos La posture choisie de l'Element
	 * @param forme La forme voulue de l'Element
	 */
	public Element(Posture pos, Forme forme) {
		this.forme=forme;
		this.pos=pos;
	}
	
	//getters
	public Posture getPos() {return pos;}
	public Forme getForme() {return forme;}
	//setters
	public void setPos(Posture pos) {this.pos = pos;}
	public void setPos(double x, double y) {this.pos.setX(x);this.pos.setY(y);}
	public void setForme(Forme forme) {this.forme = forme;}
	
	//methodes
	/**
	 * Permet de savoir si un objet est nettoyable. Retourne faux pour un objet quelconque.
	 * @return false
	 */
	public boolean isCleanable() {
		return false;
	}
	
	/** 
	 * Methode permettant de savoir si il y a collision.
	 * Retourne vrai si l'objet est en collision avec le Robot defini par robot et dans la posture post.
	 * @param robot Le Robot en question 
	 * @param pos La posture a tester
	 * @return true Si le roomba dans cette posture est en collision avec l'objet et false sinon
	 */
	public boolean isColliding(Roomba robot, Posture pos) {
		return this.forme.isColliding(robot, pos, this.pos);
	}
	
	/**
	 * Methode abstraite qui renvoie un texte descriptif de l'element
	 */
	public abstract String toString();
	
	/**
	 * Methode permettant de gerer l'interface graphique
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g) {
		g.draw(this);
	}
	
	

}

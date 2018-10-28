package forme;

import element.*;
import graphique.*;
import robot.*;

/**
 * Classe d'un Rectangle qui hérite de la classe Forme
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Rectangle extends Forme {

	//attributs
	private int longueur;
	private int largeur;
	
	//constructeurs
	/**
	 * Constructeur par defaut d'un Rectangle
	 */
	public Rectangle() {
		this.longueur=0;
		this.largeur=0;
	}
	/**
	 * Constructeur d'un Rectangle de largeur et longueur fixés
	 * @param lar La largeur voulue
	 * @param lon La longueur voulue
	 */
	public Rectangle(int lar, int lon) {
		this.longueur=lon;
		this.largeur=lar;
	}

	//getters	
	public int getLongueur() {return longueur;}
	public int getLargeur() {return largeur;}
	//setters
	public void setLongueur(int longueur) {this.longueur = longueur;}
	public void setLargeur(int largeur) {this.largeur = largeur;}

	//methodes
	/**
	 * Retourne vrai si le robot designe par robot dans la posture post est en collision avec le Rectangle.
	 * @param robot Roomba 
	 * @param pos_robot la Posture du Roomba
	 * @param pos_elem la Posture duu rectangle
	 * @return True si il y a collision et false sinon
	 */
	public boolean isColliding(Roomba robot, Posture pos_robot, Posture pos_elem ) {
		double xrob = pos_robot.getX();
		double yrob = pos_robot.getY();
		double xelem = pos_elem.getX();
		double yelem = pos_elem.getY();
		if (this.largeur>this.longueur) {
			Cercle c= new Cercle(this.longueur); //on ramene le rectangle a un cercle alligne avec le robot
			Posture pos= new Posture(xrob, yelem);
			return c.isColliding(robot, pos_robot, pos);
		}
		else {
			Cercle c= new Cercle(this.largeur);
			Posture pos= new Posture(xelem, yrob);
			return c.isColliding(robot, pos_robot, pos);	
		}
	}
	
	/**
	 * Fonction de collision entre un rectangle et un capteur de salete.
	 * @param cap Le capteur qui cherche a detecter la collision
	 * @param pos_elem La position du rectangle
	 * @return boolean
	 */
	
	public boolean collide(Capteur cap, Posture pos_elem){
		double xcap = cap.getPos().getX();
		double ycap = cap.getPos().getY();
		double xelem = pos_elem.getX();
		double yelem = pos_elem.getY();
		if (this.largeur>this.longueur) {
			Cercle c= new Cercle(this.longueur); //on ramene le rectangle a un cercle alligne avec le robot
			Posture pos= new Posture(xcap, yelem);
			//System.out.println("1-> " + c.toString() + " " + pos.toString());
			return c.collide(cap, pos);
		}
		else {
			Cercle c= new Cercle(this.largeur);
			Posture pos= new Posture(xelem, ycap);
			//System.out.println("2-> " + c.toString() +" "+ pos.toString());
			return c.collide(cap, pos);	
		}
	}
	
	/**
	 * Retourne une taille reduite a un entier dans le but d'etre comparee a d'autres formes.
	 */
	public int getHomogeneousSize() {
		return Math.min(largeur, longueur);
	}
	
	public void paint(Graphique g, Posture pos) {
		g.draw(this, pos);
	}
		
	public String toString() {
		return "de forme rectangle de longueur " + this.longueur + " et largeur " + this.largeur; 
	}

}

package forme;

import element.*;
import graphique.*;
import robot.*;

/**
 * Classe d'un Cercle qui hérite de la classe Forme.
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Cercle extends Forme {

	//attributs
	private int diametre;
	
	//constructeurs
	public Cercle() {
		this.diametre=1;
	}
	public Cercle (int diametre) {
		this.diametre=diametre;
	}
	
	
	//getters et setters
	public int getDiametre() {
		return diametre;
	}
	public void setDiametre(int diametre) {
		this.diametre = diametre;
	}
	//methodes
	/**
	 * Methode de verfication de collision avec un Roomba
	 * @param robot le Roomba
	 * @param pos_robot la nouvelle posture du robot
	 * @param pos_elem la Posture de l'element dont on souhaite verifier si il rentre en collision avec le robot dans sa nouvelle posture
	 * @return Retourne true si il y a collision et false sinon
	 */
	public boolean isColliding(Roomba robot, Posture pos_robot, Posture pos_elem ) {
		double xrob = pos_robot.getX();
		double yrob = pos_robot.getY();
		double xelem = pos_elem.getX();
		double yelem = pos_elem.getY();
		return Math.hypot(xrob-xelem,yrob-yelem) <= (robot.getForme().getHomogeneousSize()+this.diametre)/2; //on verifie que la distance centre à centre est plus petite que la somme des rayons
	}
	
	/**
	 * Methode de verfication de collision avec un autre cercle
	 * @param diam Le diametre de l'autre cercle 
	 * @param pos_cercle la Posture de l'autre cercle
	 * @param pos_elem la Posture du cercle sur lequel on applique la methode
	 * @return Retourne true si il y a collision et false sinon
	 */
	public boolean isCollidingC(double diam, Posture pos_cercle, Posture pos_elem ) {
		double xrob = pos_cercle.getX();
		double yrob = pos_cercle.getY();
		double xelem = pos_elem.getX();
		double yelem = pos_elem.getY();
		return Math.hypot(xrob-xelem,yrob-yelem) <= (diam+this.diametre)/2; //on verifie que la distance centre à centre est plus petite que la somme des rayons
	}
	
	/**
	 * Methode de collision avec un capteur de proximite
	 * @param cap le Capteur de proximite
	 * @param pos_elem la position du cercle
	 * @return boolean
	 */	
	public boolean collide(Capteur cap,Posture pos_elem ){
		if (cap.type().equals("Proximite")) {
			double x=cap.getPos().getX()+18*Math.cos(cap.getPos().getTheta()); //place le capteur a la limite du roomba, 17= rayon
			double y=cap.getPos().getY()+18*Math.sin(cap.getPos().getTheta()); //place le capteur a la limite du roomba 17= rayon
			Posture pos= new Posture(x,y);
			return this.isCollidingC(2*cap.getPortee(), pos, pos_elem);
		}
		else
			return this.isCollidingC(2*cap.getPortee(), cap.getPos(), pos_elem);
	}
	
	/**
	 * Retourne une taille reduite a un entier dans le but d'etre comparee a d'autres formes.
	 * @return Le diametre du cercle 
	 */
	public int getHomogeneousSize() {
		return diametre;
	}
		
	public String toString() {
		return "circulaire de diametre " + this.diametre; 
	}
	
	public void paint(Graphique g, Posture pos) {
		g.draw(this, pos);
	}
	

}

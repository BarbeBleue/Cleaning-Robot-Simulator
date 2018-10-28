package robot;

import element.*;
import graphique.Graphique;
import java.util.ArrayList;

/**
 * Classe abstraite permettant de definir un capteur sans savoir lequel exactement
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public abstract class Capteur {

	//attributs
	private Posture pos;
	private double portee;
	private String type;
	

	//constructeurs
	/**
	 * Constructeur par defaut de Capteur
	 */
	public Capteur(){
		this.pos = new Posture(0,0,0);
		this.portee=0;
	}
	
	/**
	 * Constructeur d'un capteur avec une position et une portee demandée
	 * @param pos La position du capteur
	 * @param portee La portee du capteur
	 */
	public Capteur(Posture pos, double portee){
		this.pos = pos;
		this.portee=portee;
	}
	
	//getters et setters
	public Posture getPos() {return pos;}
	public void setPos(Posture pos) {this.pos = pos;}
	public void setPos(double x, double y) {this.pos.setX(x);this.pos.setY(y);}
	
	public double getPortee() {return portee;}
	public void setPortee(double portee) {this.portee = portee;}
	
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	
	//methodes	
	
	
	/**
	 * Methode permettant d'afficher les caracteristiques du capteur
	 * @return String
	 */
	public String toString(){
		return "Type " + this.getType() + "position en x : " + this.pos.getX() + " position en y : " + this.pos.getY() ;
	}
	
	/**
	 * Methode abstraite pour detecter un element de l'environnement
	 * @param elem Liste des elements
	 * @return int Indice de l'element detecté ou -1 
	 */
	public abstract int detecter(ArrayList<Element> elem);
	
	/**
	 * Methode abstraite qui retourne le type du capteur
	 * @return String Le type
	 */
	public abstract String type();
	
	/**
	 * Methode abstraite pour l'interface
	 * @param g L'interface
	 */
	public abstract void paint(Graphique g);
	
}

package main;

import java.util.ArrayList;
import element.*;
import graphique.*;
import robot.*;

/**
 * Classe de l'environnement de forme rectangulaire dans lequel se deroule une simulation
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Environnement {
	
	//attributs
	private int largeur;
	private int longueur;
	private ArrayList<Element> element;
	
	//constructeur
	/**
	 * Constructeur par defaut d'un Environnement
	 */
	public Environnement() {
		this.element = new ArrayList<Element>();
		this.largeur = 400;
		this.longueur = 400;		
		
		}
	/**
	 * Constructeur parametre d'un Environnement
	 * @param lar Largeur desiree de l'environnement
	 * @param lon Longueur desiree de l'environnement
	 */
	public Environnement(int lar, int lon) {
		this.element = new ArrayList<Element>();
		this.largeur = lar;
		this.longueur = lon;
		}
	
	//getters
	public int getLargeur() {return largeur;}	
	public int getLongueur() {return longueur;}	
	public ArrayList<Element> getElement() {return element;}
	public Element getElement(int ind) { return this.element.get(ind);}
	
	//setters
	public void setLargeur(int largeur) {this.largeur = largeur;}
	public void setLongueur(int longueur) {this.longueur = longueur;}
	public void setElements(ArrayList<Element> element) {this.element = element;}
	
	//methodes
	
	/**
	 * Ajoute un element à l'Environnement
	 * @param elem L'element a ajouter
	 */
	public void addElement(Element elem) {
		this.element.add(elem);
	}
	/**
	 * Supprime l'element d'indice i contenu dans l'environnement
	 * @param ind L'indice de l'environnement a supprimer
	 */
	public void removeElement(int ind) {
		this.element.remove(ind);
	}
	
	/**
	 * Initialise un environnement de maniere predefini en vue d'une simulation
	 */
	public void init() {		
		//ajout des murs
		this.addElement(new Mur(new Posture(0,(int)this.longueur/2),4,this.longueur)); //creer le mur de gauche d'epaisseur 4
		this.addElement(new Mur(new Posture((int)this.largeur/2,0),this.largeur,4)); //creer le mur du haut
		this.addElement(new Mur(new Posture(this.largeur,(int)this.longueur/2),4,this.longueur)); //creer le mur du bas
		this.addElement(new Mur(new Posture((int) this.largeur/2,this.longueur),this.largeur,4)); //creer le mur de droite
		//ajout des obstacles
		this.addElement(new Obstacle(new Posture(30,50),60));
		this.addElement(new Obstacle(new Posture(270,270),100));
		this.addElement(new Obstacle(new Posture(300,100),50));
		this.addElement(new Obstacle(new Posture(90,250),50));
		//ajout des taches
		this.addElement(new Tache(new Posture(250,200),40));
		this.addElement(new Tache(new Posture(234,40),50));
		this.addElement(new Tache(new Posture(100,100),30));
		this.addElement(new Tache(new Posture(60,350),20));
		this.addElement(new Tache(new Posture(150,250),10));
		this.addElement(new Tache(new Posture(250,150),50));
		this.addElement(new Tache(new Posture(350,300),40));
	}
	
	
	/**
	 * Methode qui permet de vérifier que la position desiree du robot est dans l'environnement
	 * @param robot Le robot dont on souhaite verifier qu'il reste dans l'environnement
	 * @param pos La nouvelle position du robot qu'on souhaite tester
	 * @return boolean True si la position est atteignable et False sinon
	 */
	public boolean isReachable(Robot robot, Posture pos) {
		//on verifie que la nouvelle position est dans l'environnement
		if (pos.getX() <= 0 || pos.getY() <= 0 || pos.getX() > this.largeur || pos.getY() > this.longueur) {
			return false;
		}
		//on verifie que le robot n'entre pas en collision avec un element
		for (int i=0;i<this.element.size();i++){
			if (!this.element.get(i).isCleanable() && this.element.get(i).isColliding((Roomba)robot, pos)) {
				return false;
			}
		}
		return true;
	}

	public String toString() {
		String res = new String("Piece de longueur " +longueur+ "cm et de largeur " +largeur+ "cm.\n");
		res = res + "Liste des elements: \n";
		for(int i=0;i<element.size();i++) {
			res = res + (i+1) + " - " + element.get(i).toString() + "\n";
		}
		return res;
	}
	
	public void paint(Graphique g) {
		for (int i=0;i<this.element.size();i++)
			element.get(i).paint(g);
	}
	
	
	
}

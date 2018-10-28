package robot;

import forme.*;
import element.*;
import graphique.Graphique;
import java.util.ArrayList;

/**
 * Classe heritant de la classe Capteur definissant un capteur de proximite
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Capteur_prox extends Capteur{
	
	//constructeurs
	/**
	 * Constructeur par defaut de Capteur_prox
	 */
	public Capteur_prox(){
		super();
		this.setPortee(0);
		this.setType("Proximite");
	}
	
	/**
	 * Constructeur permettant de regler un capteur a une position
	 * @param pos La position voulue
	 */
	public Capteur_prox(Posture pos){
		super(pos,0);
		this.setType("Proximite");
	}
	
	//methodes
	
	/**
	 * Methode permettant de savoir si le capteur est en collision et de recuperer l'indice de 
	 * l'element en collision avec ce capteur si c'est le cas
	 * @param elem Liste des elements de l'environnement
	 * @return int : l'entier representant l'indice de l'element en colission ou -1
	 */
	public int detecter(ArrayList<Element> elem){
		int size = elem.size();
		for(int i=0;i<size;i++){ //on parcourt toute la liste des elements 
			if(elem.get(i).isCleanable()==false){ //si l'element n'est pas nettoyable
				Forme forme = elem.get(i).getForme(); 
				boolean coll = forme.collide(this,elem.get(i).getPos()); //on voit si l'element est en collision avec le capteur
				if(coll) 
					return i; //si c'est le cas on retourne l'indice de l'element detecté
			}
		}
		return -1;
	}

	/**
	 * Methode d'affectation du type du capteur
	 * @return String Le type du capteur: Proximite
	 */
	public String type(){
		return "Proximite";
	}
	
	/**
	 * Methode d'affichage des caracteristiques du capteur de proximite
	 * @return String
	 */
	public String toString(){
		double x=this.getPos().getX()+17*Math.cos(this.getPos().getTheta());
		double y=this.getPos().getY()+17*Math.sin(this.getPos().getTheta());
		return "Capteur de proximite a la position : en x "+ x +" - en y " + y + "\n";
	}
	
	/**
	 * Methode permettant d'implementer l'interface graphique du systeme
	 * @param g L'interface graphique
	 */
	public void paint(Graphique g){
		g.draw(this);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
}

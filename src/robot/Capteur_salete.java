package robot;

import element.*;
import forme.*;
import graphique.Graphique;

import java.util.ArrayList;

/**
 * Classe heritant de la classe Capteur definissant un capteur de salete
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Capteur_salete extends Capteur{
	
	//attributs
	
	//getters et setters 

	//constructeurs
	public Capteur_salete() {
		super();
		this.setPortee(5);
		this.setType("Salete");
	}
	
	public Capteur_salete(Posture pos,double portee){
		super(pos,portee);
		this.setType("Salete");
	}
	
	//methode
	/**
	 * Methode permettant de savoir si le capteur est en collision et de recuperer l'indice de 
	 * l'element en collision avec ce capteur. L'element, s'il y a collision, est donc une tache car on 
	 * verifie si celui ci est nettoyable
	 * @param elem La liste des elements dont on souhaite verifier si ils sont detectes
	 */
	public int detecter(ArrayList<Element> elem){
		int size = elem.size();
		for(int i=0;i<size;i++){ //on parcourt toute la liste des elements de l'environnement
			if(elem.get(i).isCleanable()==true){ //on regarde si l'element est nettoyable
				Forme forme = elem.get(i).getForme();
				boolean coll = forme.collide(this,elem.get(i).getPos()); //on voit si la tache est en collision avec le capteur
				if(coll) { //si c'est le cas, on renvoie l'indice de la tache
					return i;
				}
			}
		}
		return -1;
	}
	
	/**
	 * Methode retournant le type du capteur
	 * @return String Le type du capteur Salete
	 */
	public String type(){
		return "Salete";
	}
	
	/**
	 * Methode permettant d'implementer l'interface graphique du systeme
	 * @param g l'interface graphique
	 */
	public void paint(Graphique g){
		g.draw(this);
	}
	
}

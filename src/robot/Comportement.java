package robot;

import java.util.ArrayList;

/**
 * Classe abstraite d'un comportement
 * @author Maeva Arlandis et Amelie Eugene
 * 
 */

public abstract class Comportement {

	//attributs
	protected int flag;
	protected int sens;
	
	//getters et setters	
	public int getFlag() {return flag;}
	public void setFlag(int flag) {this.flag = flag;}
	
	public int getSens() {return sens;}
	public void setSens(int sens) {this.sens = sens;}
	
	// Constructeurs
	/**
	 * Constructeur par defaut d'un comportement
	 */
	public Comportement(){}
	
	//methodes
	/**
	 * Methode abstraite definissant un chemin
	 * @param capteurs Liste des capteurs
	 * @param capteursAns Tableau des reponses des capteurs
	 * @return Consigne Ce que va devoir faire le robot
	 */
	public abstract Consigne chemin(ArrayList<Capteur> capteurs, int[] capteursAns);
	
	/**
	 * Methode abstraite d'affichage
	 */
	public abstract String toString();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

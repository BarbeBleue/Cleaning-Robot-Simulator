package robot;

import java.util.ArrayList;

/**
 * Classe representant les consignes des elements moteurs du robot
 * Une consigne sera souvent a une distance a parcourir par une roue
 * @author Maeva ARLANDIS et Amelie EUGENE
 */

public class Consigne {
	
	// Attributs
	private ArrayList<Double> consignes;
	
	//getters et setters
	public ArrayList<Double> getConsignes() {return consignes;}
	public void setConsignes(ArrayList<Double> consignes) {this.consignes = consignes;}
	
	// Constructeurs
	/**
	 * Constructeur par defaut
	 */
	public Consigne(){
		consignes = new ArrayList<Double>();
	}
		
	/**
	 * Constructeur pour une consigne avec une liste donnée
	 * @param cons Liste de consigne
	 */
	public Consigne(ArrayList<Double> cons){
		consignes = cons;
	}
	
	/**
	 * Constructeur pour une consigne avce deux consignes donnees
	 * @param x Premiere consigne donnée
	 * @param y Deuxieme consigne donnée
	 */
	public Consigne(double x, double y) {
		this.consignes=new ArrayList<Double>();
		this.consignes.add(x);
		this.consignes.add(y);
	}
		
	//Methodes	
	/**
	 * Methode permettant d'obtenir la taille de consignes
	 * @return int : La taille de la consigne
	 */
	public int size(){
		return this.consignes.size();
	}
	
	/**
	 * Methode permettant d'obtenir l'element i converti en entier
	 * @param i L'elemenet a convertir
	 * @return double L'element converti en entier
	 */
	public double getConsigne(int i) {
		return this.consignes.get(i).doubleValue();
	}
	
	/**
	 * Methode qui ajoute une consigne a la liste 
	 * @param cons Consigne a ajouter
	 */
	public void addConsigne(double cons){
		this.consignes.add(new Double(cons));
	}
	
	/**
	 * Methode qui retire une consigne a la liste 
	 * @param cons Consigne a enlever
	 */
	public void removeConsigne(double cons){
		this.consignes.remove(new Double(cons));
	}
	

}
